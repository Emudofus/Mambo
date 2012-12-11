package org.mambo.shared.database.impl.internal;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.Entity;
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
public final class EntityMetadata {
    private static final Logger log = LoggerFactory.getLogger(EntityMetadata.class);
    private static final Map<Class<?>, EntityMetadata> cache = Maps.newHashMap();

    public static EntityMetadata of(Class<? extends Entity> clazz) {
        EntityMetadata metadata = cache.get(clazz);
        if (metadata == null) {
            metadata = new EntityMetadata(clazz);
            cache.put(clazz, metadata);
            metadata.load();
        }
        return metadata;
    }

    @SuppressWarnings("unchecked")
    public static EntityMetadata of(TypeToken<? extends Entity> typeToken) {
        return of((Class<? extends Entity>) typeToken.getRawType());
    }

    private final Class<? extends Entity> entityClass;

    private String tableName;
    private EntityField primaryKeyField;
    private Map<String, EntityField> fields;

    private EntityMetadata(@NotNull Class<? extends Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @NotNull
    public Class<? extends Entity> getEntityClass() {
        return entityClass;
    }

    @NotNull
    public EntityField getPrimaryKeyField() {
        return primaryKeyField;
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

    private EntityField load(Field field) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        if (columnAnnotation == null) return null;

        String name = columnAnnotation.name();
        if (Strings.isNullOrEmpty(name)) {
            name = field.getName();
        }

        EntityField entityField = new EntityField(this, field, name);

        if (field.isAnnotationPresent(ManyToOne.class)) {
            ManyToOne m2oAnnotation = field.getAnnotation(ManyToOne.class);

            @SuppressWarnings("unchecked")
            EntityMetadata to = of((Class<? extends Entity>) field.getType());

            entityField.setConverter(new Dependency(
                    this,
                    to,
                    entityField,
                    m2oAnnotation.targetField(),
                    Dependency.Type.MANY_TO_ONE
            ));
        } else if (field.isAnnotationPresent(OneToMany.class)) {
            OneToMany o2mAnnotation = field.getAnnotation(OneToMany.class);

            @SuppressWarnings("unchecked")
            EntityMetadata to = of((Class<? extends Entity>) o2mAnnotation.value());

            entityField.setConverter(new Dependency(
                    this,
                    to,
                    entityField,
                    o2mAnnotation.mappedBy(),
                    Dependency.Type.ONE_TO_MANY
            ));
        } else {
            Class<?> clazzConverter = columnAnnotation.converter();
            if (clazzConverter != Column.DEFAULT_CONVERTER.class && ColumnConverter.class.isAssignableFrom(clazzConverter)) {
                try {
                    entityField.setConverter((ColumnConverter) clazzConverter.newInstance());
                } catch (Throwable t) {
                    log.error(String.format("can't create converter of field %s in %s", field.getName(), entityClass.getName()), t);
                }
            }
        }

        return entityField;
    }

    private void load() {
        Table tableAnnotation = entityClass.getAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new RuntimeException("entity \"" + entityClass.getName() + "\" must be annotated with @Table");
        }

        if (!Strings.isNullOrEmpty(tableAnnotation.value())) {
            tableName = tableAnnotation.value();
        } else {
            tableName = UPPER_CAMEL.to(LOWER_UNDERSCORE, entityClass.getSimpleName().toLowerCase()) + "s";
        }

        fields = Maps.newHashMap();
        for (Field field : entityClass.getDeclaredFields()) {
            EntityField entityField = load(field);

            if (entityField != null) {
                fields.put(entityField.getColumnName(), entityField);

                if (field.isAnnotationPresent(Id.class)) {
                    if (primaryKeyField != null) {
                        throw new RuntimeException("an entity can't have multiple id");
                    }
                    primaryKeyField = entityField;
                }
            }
        }

        checkNotNull(primaryKeyField, "%s must have a primary key", entityClass);
    }
}
