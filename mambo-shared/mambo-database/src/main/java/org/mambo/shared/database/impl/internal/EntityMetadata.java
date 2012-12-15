package org.mambo.shared.database.impl.internal;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.MutableEntity;
import org.mambo.shared.database.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
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
    private Map<String, EntityField<E>> fields;

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

    private EntityField<E> load(Field field) {
        if (!Entity.class.isAssignableFrom(entityClass)) {
            throw new RuntimeException(entityClass.getName() + " must be implement " + Entity.class.getName());
        }

        Column columnAnnotation = field.getAnnotation(Column.class);
        if (columnAnnotation == null) return null;

        String name = columnAnnotation.name();
        if (Strings.isNullOrEmpty(name)) {
            name = field.getName();
        }

        EntityField<E> entityField = new EntityField<E>(this, field, name);

        if (field.isAnnotationPresent(ManyToOne.class)) {
            ManyToOne m2oAnnotation = field.getAnnotation(ManyToOne.class);

            @SuppressWarnings("unchecked")
            EntityMetadata to = of((Class<? extends Entity>) field.getType());

            entityField.setConverter(new Dependency<E>(
                    this,
                    to,
                    entityField,
                    m2oAnnotation.targetField(),
                    Dependency.Type.MANY_TO_ONE
            ));
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
            EntityMetadata to = of((Class) type.getActualTypeArguments()[0]);

            entityField.setConverter(new Dependency<E>(
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
            EntityField<E> entityField = load(field);

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
