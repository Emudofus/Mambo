package org.mambo.shared.database.impl.internal;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 17:36
 */
public final class Dependency<E extends Entity> implements ColumnConverter {
    public static enum Type {
        ONE_TO_MANY,
        MANY_TO_ONE,
        //MANY_TO_MANY,
    }

    private final EntityMetadata<E> from;
    private final EntityMetadata<?> to;
    private final EntityField<E> field;
    private final String triggerProperty;
    private final Type type;

    public Dependency(@NotNull EntityMetadata<E> from, @NotNull EntityMetadata<?> to, @NotNull EntityField<E> field, @NotNull String triggerProperty, @NotNull Type type) {
        this.from = checkNotNull(from);
        this.to = checkNotNull(to);
        this.field = checkNotNull(field);
        this.triggerProperty = checkNotNull(triggerProperty);
        this.type = checkNotNull(type);
    }

    @NotNull
    public EntityMetadata<E> getFrom() {
        return from;
    }

    @NotNull
    public EntityMetadata<?> getTo() {
        return to;
    }

    @NotNull
    public EntityField<E> getField() {
        return field;
    }

    @NotNull
    public String getTriggerProperty() {
        return triggerProperty;
    }

    @NotNull
    public Type getType() {
        return type;
    }

    @Override
    public Object extract(@NotNull DatabaseContext ctx, @NotNull ResultSet rset) throws SQLException {
        Repository<?> repository = ctx.get(to.getEntityClass());
        EntityField<?> trigger = to.getField(triggerProperty);

        switch (type) {
        case MANY_TO_ONE:
            String columnName = field.getColumnName() + "_" + trigger.getColumnName();
            Object id = rset.getObject(columnName);
            return References.create(repository, id);

        case ONE_TO_MANY:
            if (!(trigger.getConverter() instanceof Dependency)) {
                throw new RuntimeException("invalid trigger \"" + trigger.getColumnName() + "\"");
            }
            Dependency<?> triggerDependency = (Dependency<?>) trigger.getConverter();

            String targetPropertyName = triggerDependency.triggerProperty;
            Object value = rset.getObject(targetPropertyName);

            return repository.findAll(trigger.getColumnName(), value);

        default:
            throw new SQLException("can't extract dependency type " + type);
        }
    }

    @Override
    public void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> values) {
        EntityField<?> trigger = to.getField(triggerProperty);

        switch (type) {
        case MANY_TO_ONE:
            String columnName = field.getColumnName() + "_" + trigger.getColumnName();
            Object value = trigger.unsafeGet(field.unsafeGet(obj));
            values.put(columnName, value);
            break;

        case ONE_TO_MANY: // nothing to do
            break;
        }
    }
}
