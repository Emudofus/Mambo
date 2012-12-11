package org.mambo.shared.database.impl.internal;

import com.googlecode.cqengine.attribute.Attribute;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;

import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/12/12
 * Time: 22:10
 */
public final class EntityAttribute<E extends Entity> implements Attribute<E, Object> {
    private final EntityField field;

    public EntityAttribute(@NotNull EntityField field) {
        this.field = checkNotNull(field);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<E> getObjectType() {
        return (Class<E>) field.getOwner().getEntityClass();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<Object> getAttributeType() {
        return (Class<Object>) field.getType();
    }

    @Override
    public String getAttributeName() {
        return field.getColumnName();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object> getValues(E object) {
        Object value = field.get(object);
        if (value instanceof List<?>) {
            return (List<Object>) value;
        }
        return Collections.singletonList(value);
    }
}
