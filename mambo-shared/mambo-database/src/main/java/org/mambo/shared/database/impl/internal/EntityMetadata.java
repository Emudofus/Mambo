package org.mambo.shared.database.impl.internal;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:37
 */
public final class EntityMetadata {
    private static final Logger log = LoggerFactory.getLogger(EntityMetadata.class);

    public static EntityMetadata of(Class<?> clazz) {
        return new EntityMetadata(clazz);
    }

    public static EntityMetadata of(TypeToken<?> typeToken) {
        return of(typeToken.getRawType());
    }

    private final Class<?> entityClass;

    private Class<?> primaryKeyClass;
    private String tableName;
    private Map<String, EntityField> fields;

    private EntityMetadata(@NotNull Class<?> entityClass) {
        this.entityClass = entityClass;
        load();
    }

    @NotNull
    public Class<?> getEntityClass() {
        return entityClass;
    }

    @NotNull
    public Class<?> getPrimaryKeyClass() {
        return primaryKeyClass;
    }

    @NotNull
    public Object createEmpty() {
        try {
            return entityClass.newInstance();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @NotNull
    public String getTableName() {
        return tableName;
    }

    @NotNull
    public Map<String, EntityField> getFields() {
        return fields;
    }

    public EntityField getField(@NotNull String name) {
        return fields.get(checkNotNull(name));
    }

    private void load() {
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            tableName = tableAnnotation.value();
        } else {
            tableName = entityClass.getSimpleName().toLowerCase() + "s";
        }

        fields = Maps.newHashMap();
        for (Field field : entityClass.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation == null) continue;

            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation != null) {
                primaryKeyClass = field.getType();
            }

            Class<?> clazzConverter = columnAnnotation.converter();
            ColumnConverter converter = null;
            if (clazzConverter != Column.DEFAULT_CONVERTER.class && ColumnConverter.class.isAssignableFrom(clazzConverter)) {
                try {
                    converter = (ColumnConverter) clazzConverter.newInstance();
                } catch (Throwable t) {
                    log.error(String.format("can't create converter of field %s in %s", field.getName(), entityClass.getName()), t);
                }
            }

            String name = columnAnnotation.name();
            if (name == null || name.isEmpty()) {
                name = field.getName();
            }

            EntityField entityField = new EntityField(field, name, converter);
            fields.put(entityField.getColumnName(), entityField);
        }

        checkNotNull(primaryKeyClass, "%s must have a primary key", entityClass);
    }
}
