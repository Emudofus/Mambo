package org.mambo.shared.database.impl.internal;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.MutableEntity;
import org.mambo.shared.database.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:37
 */
public final class EntityMetadata<E extends Entity> {
    private static final Logger log = LoggerFactory.getLogger(EntityMetadata.class);
    private static final Map<Class<?>, EntityMetadata> cache = Maps.newHashMap();

    public static <E extends Entity> EntityMetadata<E> of(Class<E> clazz) {
        @SuppressWarnings("unchecked")
        EntityMetadata<E> metadata = (EntityMetadata<E>) cache.get(clazz);

        if (metadata == null) {
            metadata = new EntityMetadata<E>(clazz);
            cache.put(clazz, metadata);
            metadata.load();
        }

        return metadata;
    }

    @SuppressWarnings("unchecked")
    public static <E extends Entity> EntityMetadata<E> of(TypeToken<E> typeToken) {
        return of((Class) typeToken.getRawType());
    }

    private final Class<E> entityClass;
    private final boolean mutable;

    private String tableName;
    private EntityField<E> primaryKeyField;
    private final Map<String, EntityField<E>> fields = Maps.newHashMap();

    private EntityMetadata(@NotNull Class<E> entityClass) {
        this.entityClass = entityClass;
        this.mutable = MutableEntity.class.isAssignableFrom(entityClass);
    }

    @NotNull
    public Class<E> getEntityClass() {
        return entityClass;
    }

    public boolean isMutable() {
        return mutable;
    }

    @NotNull
    public EntityField<E> getPrimaryKeyField() {
        return primaryKeyField;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public E createEmpty() {
        if (!mutable) {
            throw new UnsupportedOperationException(entityClass + " is immutable, instanciation are forbidden");
        }

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
    public Map<String, EntityField<E>> getFields() {
        return fields;
    }

    public EntityField<E> getField(@NotNull String name) {
        return fields.get(checkNotNull(name));
    }

    private void load() {
        loadTableName();
        loadFields();
    }

    private void loadTableName() {
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new RuntimeException("entity \"" + entityClass.getName() + "\" must be annotated with @Table");
        }

        if (!Strings.isNullOrEmpty(tableAnnotation.value())) {
            tableName = tableAnnotation.value();
        } else {
            tableName = UPPER_CAMEL.to(LOWER_UNDERSCORE, entityClass.getSimpleName().toLowerCase()) + "s";
        }
    }

    private static void getOverrides(Map<String, Column> result, Class<?> clazz) {
        ColumnOverrides overrides = clazz.getAnnotation(ColumnOverrides.class);
        if (overrides != null) {
            for (ColumnOverride override : overrides.value()) {
                result.put(override.name(), override.by());
            }
        } else {
            ColumnOverride override = clazz.getAnnotation(ColumnOverride.class);
            if (override != null) {
                result.put(override.name(), override.by());
            }
        }
    }

    private EntityField<E> loadField(Field field, Map<String, Column> overrides) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        if (columnAnnotation == null) return null;

        String name = columnAnnotation.name();
        if (Strings.isNullOrEmpty(name)) {
            name = field.getName();
        }

        Column overrideColumnAnnotation = overrides.get(name);
        if (overrideColumnAnnotation != null) {
            columnAnnotation = overrideColumnAnnotation;

            if (!Strings.isNullOrEmpty(overrideColumnAnnotation.name())) {
                name = overrideColumnAnnotation.name();
            }
        }

        return new EntityField<E>(this, field, name, columnAnnotation);
    }

    private void loadFields() {
        Map<String, Column> overrides = Maps.newHashMap();
        Class<?> clazz = entityClass;
        do {
            getOverrides(overrides, clazz);

            for (Field field : clazz.getDeclaredFields()) {
                EntityField<E> entityField = loadField(field, overrides);
                if (entityField != null) {
                    fields.put(entityField.getColumnName(), entityField);
                }

                if (field.isAnnotationPresent(Id.class)) {
                    if (primaryKeyField != null) {
                        throw new RuntimeException("an entity can't have multiple id");
                    }
                    primaryKeyField = entityField;
                }
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        checkNotNull(primaryKeyField, "%s must have a primary key", entityClass);
    }
}
