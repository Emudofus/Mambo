package org.mambo.core.event;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.inject.TypeLiteral;
import org.jetbrains.annotations.NotNull;
import org.mambo.core.Exceptions;
import org.mambo.core.collect.SortedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author Blackrush
 *         Mambo
 */
public class ReflectiveEventHandlerManager extends EventHandlerManager {
    private static final Logger log = LoggerFactory.getLogger(ReflectiveEventHandlerManager.class);

    private final Map<TypeLiteral<?>, List<Holder>> holders = Maps.newHashMap();

    protected void put(TypeLiteral<?> messageClass, Holder holder) {
        List<Holder> holders = this.holders.get(messageClass);
        if (holders == null) {
            holders = SortedList.create();
            this.holders.put(messageClass, holders);
        }
        holders.add(holder);
    }

    @Override
    public void onRegistered(@NotNull Class<?> handlerClass) {
        for (Method method : handlerClass.getMethods()) {
            EventHandler annotation = method.getAnnotation(EventHandler.class);
            if (annotation == null) break;

            Type[] types = method.getGenericParameterTypes();
            if (types.length != 1) {
                throw new RuntimeException("an EventHandler must take only one parameter Event<M>");
            }

            TypeLiteral<?> messageClass;
            Holder holder;

            Type type = types[0];
            if (type instanceof Class<?>) {
                messageClass = TypeLiteral.get(type);
                holder = new Holder(false, method, annotation.priority());
            } else {
                ParameterizedType pType = (ParameterizedType) type;
                if (pType.getActualTypeArguments().length != 1) {
                    throw new RuntimeException("can't determine message class : it has no or more than one type arguments");
                }

                messageClass = TypeLiteral.get(pType.getActualTypeArguments()[0]);
                holder = new Holder(true, method, annotation.priority());
            }

            method.setAccessible(true);

            put(messageClass, holder);
        }
    }

    @Override
    public void onUnregistered(@NotNull Class<?> handlerClass) {

    }

    @Override
    public void dispatch(@NotNull Multimap<Class<?>, Object> handlers, @NotNull Event<?> event) {
        List<Holder> holders = this.holders.get(TypeLiteral.get(event.get().getClass()));
        if (holders == null) return;

        Exceptions exceptions = Exceptions.create();

        for (Holder holder : holders) {
            for (Object handler : handlers.get(holder.method.getDeclaringClass())) {
                if (event.hasBeenStopped()) return;

                try {
                    if (holder.event) {
                        holder.method.invoke(handler, event);
                    } else {
                        holder.method.invoke(handler, event.get());
                    }
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
        private final boolean event;
        private final Method method;
        private final EventHandler.Priority priority;

        private Holder(boolean event, Method method, EventHandler.Priority priority) {
            this.event = event;
            this.method = method;
            this.priority = priority;
        }

        @Override
        public int compareTo(Holder o) {
            return priority.ordinal() - o.priority.ordinal();
        }
    }
}
