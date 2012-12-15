package org.mambo.shared.database.impl.internal;

import com.google.common.base.CaseFormat;
import com.googlecode.cqengine.attribute.Attribute;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.ManyToOne;
import org.mambo.shared.database.annotations.OneToMany;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:48
 */
public final class EntityField<E extends Entity> {
    public static Method getter(Field field) {
        Class<?> clazz = field.getDeclaringClass();
        String fieldName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, field.getName());
        Method method;

        try {
            if (field.getType() == boolean.class) {
                try {
                    method = clazz.getMethod("is" + fieldName);
                } catch (NoSuchMethodException e) {
                    method = clazz.getMethod("has" + fieldName);
                }
            } else {
                method = clazz.getMethod("get" + fieldName);
            }
        } catch (NoSuchMethodException e) {
            method = null;
        }

        return method;
    }

    public static Method setter(Field field) {
        String propertyName = "set" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, field.getName());

        for (Method method : field.getDeclaringClass().getMethods()) {
            if (method.getName().equals(propertyName) && method.getParameterTypes().length == 1) {
                return method;
            }
        }

        return null;
    }

    private final EntityMetadata<E> owner;
    private final Field field;
    private final Column definition;
    private final String columnName;
    private final Method getter, setter;

    private ColumnConverter converter;

    EntityField(@NotNull EntityMetadata<E> owner, @NotNull Field field, @NotNull String columnName, @NotNull Column definition) {
        this.owner = checkNotNull(owner);
        this.field = checkNotNull(field);
        this.definition = checkNotNull(definition);
        this.columnName = checkNotNull(columnName);

        this.getter = checkNotNull(getter(field), "%s is not a valid JavaBean : can't find getter for field %s", owner.getEntityClass().getName(), field.getName());
        this.setter = owner.isMutable()
                ? checkNotNull(setter(field), "%s is not a valid JavaBean : can't find setter for field %s", owner.getEntityClass().getName(), field.getName())
                : null;

        load();
    }

    @NotNull
    public EntityMetadata<E> getOwner() {
        return owner;
    }

    /**
     * @return field's type
     */
    public Class<?> getType() {
        return field.getType();
    }

    /**
     * @param entity entity instance
     * @return entity's property value
     */
    public Object get(E entity) {
        try {
            return getter.invoke(entity);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Deprecated
    Object unsafeGet(Object entity) {
        return get(owner.getEntityClass().cast(entity));
    }

    /**
     * @param entity entity instance
     * @param obj entity's new property value
     */
    public void set(E entity, Object obj) {
        if (setter == null) {
            throw new UnsupportedOperationException(owner.getEntityClass() + " is immutable");
        }
        try {
            setter.invoke(entity, obj);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Deprecated
    void unsafeSet(Object entity, Object obj) {
        set(owner.getEntityClass().cast(entity), obj);
    }

    public String getColumnName() {
        return columnName;
    }

    public ColumnConverter getConverter() {
        return converter;
    }

    @NotNull
    public Attribute<E, Object> asAttribute() {
        return new EntityAttribute<E>(this);
    }

    private void load() {
        if (field.isAnnotationPresent(ManyToOne.class)) {
            ManyToOne m2oAnnotation = field.getAnnotation(ManyToOne.class);

            @SuppressWarnings("unchecked")
            EntityMetadata to = EntityMetadata.of((Class<? extends Entity>) field.getType());

            converter = new Dependency<E>(
                    owner,
                    to,
                    this,
                    m2oAnnotation.targetField(),
                    Dependency.Type.MANY_TO_ONE
            );
        } else if (field.isAnnotationPresent(OneToMany.class)) {
            OneToMany o2mAnnotation = field.getAnnotation(OneToMany.class);

            if (field.getType() != List.class) {
                throw new RuntimeException("OneToMany dependency has to be a java.util.List");
            }
            if (!(field.getGenericType() instanceof ParameterizedType)) {
                throw new RuntimeException(field.getName() + " is not parameterized");
            }

            ParameterizedType type = (ParameterizedType) field.getGenericType();
            @SuppressWarnings("unchecked")
            EntityMetadata to = EntityMetadata.of((Class) type.getActualTypeArguments()[0]);

            converter = new Dependency<E>(
                    owner,
                    to,
                    this,
                    o2mAnnotation.mappedBy(),
                    Dependency.Type.ONE_TO_MANY
            );
        } else {
            Class<?> clazzConverter = definition.converter();
            if (clazzConverter != Column.DEFAULT_CONVERTER.class && ColumnConverter.class.isAssignableFrom(clazzConverter)) {
                try {
                    converter = (ColumnConverter) clazzConverter.newInstance();
                } catch (Throwable t) {
                    throw new RuntimeException(t);
                }
            }
        }
    }
}
