package org.mambo.shared.database.impl.internal;

import com.google.common.base.CaseFormat;
import com.googlecode.cqengine.attribute.Attribute;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.MutableEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:48
 */
public final class EntityField {
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

    private final EntityMetadata owner;
    private final Field field;
    private final String columnName;
    private final Method getter, setter;

    private ColumnConverter converter;

    EntityField(@NotNull EntityMetadata owner, @NotNull Field field, @NotNull String columnName) {
        this.owner = checkNotNull(owner);
        this.field = checkNotNull(field);
        this.columnName = checkNotNull(columnName);

        this.getter = checkNotNull(getter(field), "%s is not a valid JavaBean : can't find getter for field %s", owner.getEntityClass().getName(), field.getName());
        this.setter = MutableEntity.class.isAssignableFrom(owner.getEntityClass()) ? setter(field) : null;
    }

    @NotNull
    public EntityMetadata getOwner() {
        return owner;
    }

    /**
     * @return class's field
     */
    public Field getField() {
        return field;
    }

    /**
     * @return field's type
     */
    public Class<?> getType() {
        return field.getType();
    }

    /**
     * @param instance entity instance
     * @return entity's property value
     */
    public Object get(Object instance) {
        try {
            return getter.invoke(instance);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    /**
     * @param instance entity instance
     * @param obj entity's new property value
     */
    public void set(Object instance, Object obj) {
        if (setter == null) {
            throw new UnsupportedOperationException("you can't set a property, you should implements MutableEntity");
        }
        try {
            setter.invoke(instance, obj);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public String getColumnName() {
        return columnName;
    }

    public ColumnConverter getConverter() {
        return converter;
    }

    public void setConverter(ColumnConverter converter) {
        this.converter = converter;
    }

    public <T extends Annotation> T getAnnotation(Class<T> clazz) {
        return field.getAnnotation(clazz);
    }

    @NotNull
    public <E extends Entity> Attribute<E, Object> asAttribute() {
        return new EntityAttribute<E>(this);
    }
}
