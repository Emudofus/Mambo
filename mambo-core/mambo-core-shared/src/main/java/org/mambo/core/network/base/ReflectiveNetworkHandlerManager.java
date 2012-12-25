package org.mambo.core.network.base;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.Exceptions;
import org.mambo.core.network.NetworkClient;
import org.mambo.core.network.NetworkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 18:39
 */
public class ReflectiveNetworkHandlerManager<T extends NetworkClient> extends BaseNetworkHandlerManager<T> {
    private class Hook {
        private final NetworkHandler<T> handler;
        private final Method method;

        private Hook(NetworkHandler<T> handler, Method method) {
            this.handler = handler;
            this.method = method;
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ReflectiveNetworkHandlerManager.class);

    private final SetMultimap<Class<?>, Hook> methods = HashMultimap.create();

    public ReflectiveNetworkHandlerManager(@NotNull Set<NetworkHandler<T>> handlers) {
        super(handlers);
        init();
    }

    private void init() {
        for (NetworkHandler<T> handler : this) {
            Class<?> handlerClass = handler.getClass();

            for (Method method : handlerClass.getMethods()) {
                if (!method.isAnnotationPresent(NetworkHandler.Handler.class)) continue;

                Class<?>[] handlerParameters = method.getParameterTypes();
                if (handlerParameters.length != 2) {
                    log.error("\"{}\" action's \"{}\" must have only 2 arguments : client and message", handlerClass.getName(), method.getName());
                } else if (!NetworkClient.class.isAssignableFrom(handlerParameters[0])) {
                    log.error("\"{}\" action's \"{}\" must have in first argument a NetworkClient", handlerClass.getName(), method.getName());
                } else {
                    Class<?> messageClass = handlerParameters[1];
                    methods.put(messageClass, new Hook(handler, method));
                }
            }
        }
    }

    @Override
    public void dispatchMessage(@NotNull T client, @NotNull Object message) {
        checkNotNull(client);
        checkNotNull(message);

        Exceptions exceptions = Exceptions.create();

        Set<Hook> hooks = methods.get(message.getClass());
        for (Hook hook : hooks) {
            try {
                hook.method.invoke(hook.handler, client, message);
            } catch (IllegalAccessException ignored) {
                // all handler's actions must be accessibles (see above)
            } catch (InvocationTargetException e) {
                exceptions.add(e.getTargetException());
            }
        }

        exceptions.throwAll();
    }
}
