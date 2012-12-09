package org.mambo.shared.database.impl.internal;

import com.google.common.base.CaseFormat;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;

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
    public static Method getter(Field field) throws NoSuchMethodException {
        Class<?> clazz = field.getDeclaringClass();
        String fieldName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, field.getName());
        Method method;

        if (field.getType() == boolean.class) {
            try {
                method = clazz.getMethod("is" + fieldName);
            } catch (NoSuchMethodException e) {
                method = clazz.getMethod("has" + fieldName);
            }
        } else {
            method = clazz.getMethod("get" + fieldName);
        }

        return method;
    }

    public static Method setter(Field field) throws NoSuchMethodException {
        Class<?> clazz = field.getDeclaringClass(),
                 type  = field.getType();
        return clazz.getMethod("set" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, field.getName()), type);
    }

    private final Field field;
    private final String columnName;
    private final ColumnConverter converter;

    private final Method getter, setter;

    EntityField(@NotNull Field field, @NotNull String columnName, ColumnConverter converter) {
        this.field = checkNotNull(field);
        this.columnName = checkNotNull(columnName);
        this.converter = converter;

        try {
            this.getter = getter(field);
            this.setter = setter(field);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("entity must be a valid JavaBean", e);
        }
    }

    /**
     * @return class's field
     */
    public Field getField() {
        return field;
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
}
