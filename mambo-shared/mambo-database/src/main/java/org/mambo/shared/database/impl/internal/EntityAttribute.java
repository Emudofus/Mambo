package org.mambo.shared.database.impl.internal;

import com.googlecode.cqengine.attribute.SimpleAttribute;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.Entity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/12/12
 * Time: 22:10
 */
public final class EntityAttribute<E extends Entity> extends SimpleAttribute<E, Object> {
    private final EntityField<E> field;

    @SuppressWarnings("unchecked")
    public EntityAttribute(@NotNull EntityField<E> field) {
        super(field.getOwner().getEntityClass(), (Class<Object>) field.getType(), field.getColumnName());
        this.field = checkNotNull(field);
    }

    @Override
    public Object getValue(E object) {
        return field.get(object);
    }
}
