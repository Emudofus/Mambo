package org.mambo.shared.database.impl.internal;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ColumnConverter;
import org.mambo.shared.database.DatabaseContext;
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
public final class Dependency implements ColumnConverter {
    public static enum Type {
        ONE_TO_MANY,
        MANY_TO_ONE,
        //MANY_TO_MANY,
    }

    private final EntityMetadata from, to;
    private final EntityField field;
    private final String triggerProperty;
    private final Type type;

    public Dependency(@NotNull EntityMetadata from, @NotNull EntityMetadata to, @NotNull EntityField field, @NotNull String triggerProperty, @NotNull Type type) {
        this.from = checkNotNull(from);
        this.to = checkNotNull(to);
        this.field = checkNotNull(field);
        this.triggerProperty = checkNotNull(triggerProperty);
        this.type = checkNotNull(type);
    }


    public Dependency reverse() {
        for (EntityField field : to.getFields().values()) {
            if (field.getConverter() instanceof Dependency) {
                Dependency dependency = (Dependency) field.getConverter();
                if (dependency.to == from) {
                    return dependency;
                }
            }
        }
        return null;
    }

    @Override
    public Object extract(@NotNull DatabaseContext ctx, @NotNull ResultSet rset) throws SQLException {
        Repository<?> repository = ctx.getEntity(to.getEntityClass());
        EntityField trigger = to.getField(triggerProperty);

        switch (type) {
        case MANY_TO_ONE:
            String columnName = field.getColumnName() + "_" + trigger.getColumnName();
            Object id = rset.getObject(columnName);
            return References.create(repository, to, id);

        case ONE_TO_MANY:
            if (!(trigger.getConverter() instanceof Dependency)) {
                throw new RuntimeException("invalid trigger \"" + trigger.getColumnName() + "\"");
            }
            Dependency triggerDependency = (Dependency) trigger.getConverter();

            String targetPropertyName = triggerDependency.triggerProperty;
            Object value = rset.getObject(targetPropertyName);

            return repository.findAll(trigger.getColumnName(), value);

        default:
            throw new SQLException("can't extract dependency type " + type);
        }
    }

    @Override
    public void export(@NotNull DatabaseContext ctx, @NotNull Object obj, @NotNull Map<String, Object> export) throws SQLException {
        EntityField trigger = to.getField(triggerProperty);

        switch (type) {
        case MANY_TO_ONE:
            String columnName = field.getColumnName() + "_" + trigger.getColumnName();
            Object value = trigger.get(field.get(obj));
            export.put(columnName, value);
            break;

        case ONE_TO_MANY: // nothing to do
            break;

        default:
            throw new SQLException("can't export dependency type " + type);
        }
    }
}
