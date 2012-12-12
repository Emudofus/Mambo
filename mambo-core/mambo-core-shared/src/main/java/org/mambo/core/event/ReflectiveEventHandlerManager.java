package org.mambo.core.event;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/**
 * @author Blackrush
 *         Mambo
 */
public class ReflectiveEventHandlerManager extends EventHandlerManager {
    private static final Logger log = LoggerFactory.getLogger(ReflectiveEventHandlerManager.class);

    private final Map<Class<?>, Set<Holder>> holders = Maps.newHashMap();

    protected void put(Class<?> messageClass, Holder holder) {
        Set<Holder> holders = this.holders.get(messageClass);
        if (holders == null) {
            holders = Sets.newTreeSet();
            this.holders.put(messageClass, holders);
        }
        holders.add(holder);
    }

    @Override
    public void onRegistered(@NotNull Class<?> handlerClass) {
        for (Method method : handlerClass.getMethods()) {
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            if (annotation == null) break;

            Class<?>[] parameters = method.getExceptionTypes();
            if (parameters.length != 1 || parameters[0] != EventInterface.class) {
                throw new RuntimeException("an EventHandler must take only one parameter EventInterface<M>");
            }

            Type type = method.getGenericParameterTypes()[0];
            if (!(type instanceof ParameterizedType)) {
                throw new RuntimeException("can't determines message's class");
            }

            Type messageType = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (!(messageType instanceof Class<?>)) {
                throw new RuntimeException("can't determines message's class");
            }

            Class<?> messageClass = (Class<?>) messageType;
            Holder holder = new Holder(method, annotation.priority());

            put(messageClass, holder);
        }
    }

    @Override
    public void onUnregistered(@NotNull Class<?> handlerClass) {

    }

    @Override
    public void dispatch(@NotNull Multimap<Class<?>, Object> handlers, @NotNull EventInterface<?> event) {
        Set<Holder> holders = this.holders.get(event.get().getClass());
        if (holders == null) return;

        Exceptions exceptions = Exceptions.create();

        for (Holder holder : holders) {
            for (Object handler : handlers.get(holder.method.getDeclaringClass())) {
                if (event.hasBeenStopped()) return;

                try {
                    holder.method.invoke(handler, event);
                } catch (IllegalAccessException e) {
                    log.error("can't dispatch event", e);
                } catch (InvocationTargetException e) {
                    exceptions.add(e);
                }
            }
        }

        exceptions.throwAll();
    }

    private static class Holder implements Comparable<Holder> {
        private final Method method;
        private final EventHandler.Priority priority;

        private Holder(Method method, EventHandler.Priority priority) {
            this.method = method;
            this.priority = priority;
        }

        @Override
        public int compareTo(Holder o) {
            return priority.ordinal() - o.priority.ordinal();
        }
    }
}
