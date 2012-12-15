package org.mambo.shared.database.persistence;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.impl.internal.EntityField;
import org.mambo.shared.database.impl.internal.EntityMetadata;

import javax.inject.Provider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Blackrush
 *         Mambo
 */
public class JdbcPersistenceStrategy implements PersistenceStrategy {
    private final Provider<Connection> provider;

    public JdbcPersistenceStrategy(@NotNull Provider<Connection> provider) {
        this.provider = checkNotNull(provider);
    }

    @NotNull
    @Override
    public <E extends Entity> Set<E> load(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata) {
        Connection connection = provider.get();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rset = statement.executeQuery(getLoadQuery(metadata));
            return load(ctx, metadata, rset);
        } catch (SQLException e) {
            throw new RuntimeException("can't load table \"" + metadata.getTableName() + "\"", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {}
            }
        }
    }

    @Override
    public <E extends Entity> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Connection connection = provider.get();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(getInsertQuery(ctx, metadata, entity));
        } catch (SQLException e) {
            throw new RuntimeException("can't insert data in table \"" + metadata.getTableName() + "\"");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored){}
            }
        }
    }

    @Override
    public <E extends Entity> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Connection connection = provider.get();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(getUpdateQuery(ctx, metadata, entity));
        } catch (SQLException e) {
            throw new RuntimeException("can't insert data in table \"" + metadata.getTableName() + "\"");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored){}
            }
        }
    }

    @Override
    public <E extends Entity> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Connection connection = provider.get();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(getDeleteQuery(metadata, entity));
        } catch (SQLException e) {
            throw new RuntimeException("can't insert data in table \"" + metadata.getTableName() + "\"");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored){}
            }
        }
    }

    @NotNull
    public static <E extends Entity> Map<String, Object> exportValues(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Map<String, Object> values = Maps.newHashMap();
        for (EntityField<E> field : metadata.getFields().values()) {
            if (field.getConverter() != null) {
                field.getConverter().export(ctx, entity, values);
            } else {
                values.put(field.getColumnName(), field.get(entity));
            }
        }
        return values;
    }

    @NotNull
    public static <E extends Entity> String getLoadQuery(@NotNull EntityMetadata<E> metadata) {
        return "select * from `" + metadata.getTableName() + "`;"; // TODO dependencies
    }

    @NotNull
    public static <E extends Entity> String getInsertQuery(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Map<String, Object> values = exportValues(ctx, metadata, entity);
        StringBuilder query = new StringBuilder();
        boolean first;

        query.append("insert into `").append(metadata.getTableName()).append('`');

        query.append('(');
        first = true;
        for (String columnName : values.keySet()) {
            if (first) first = false;
            else query.append(", ");
            query.append('`').append(columnName).append('`');
        }
        query.append(") ");

        query.append("values(");
        first = true;
        for (Object value : values.values()) {
            if (first) first = false;
            else query.append(", ");
            query.append('\'').append(value).append('\'');
        }
        query.append(");");

        return query.toString();
    }

    @NotNull
    public static <E extends Entity> String getUpdateQuery(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        Map<String, Object> values = exportValues(ctx, metadata, entity);
        StringBuilder query = new StringBuilder();
        boolean first;

        query.append("update `").append(metadata.getTableName()).append('`');

        query.append("set ");
        first = true;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            if (first) first = false;
            else query.append(", ");
            query.append('`').append(entry.getKey()).append("` = ")
                    .append('\'').append(entry.getValue()).append('\'');
        }

        query.append("where `").append(metadata.getPrimaryKeyField().getColumnName())
                .append("` = '").append(entity.getId()).append("';");

        return query.toString();
    }

    @NotNull
    public static <E extends Entity> String getDeleteQuery(@NotNull EntityMetadata<E> metadata, @NotNull E entity) {
        return "delete from `" + metadata.getTableName() + "` " +
                "where `" + metadata.getPrimaryKeyField().getColumnName() + "` = '" + entity.getId() + "';";
    }

    @NotNull
    public static <E extends Entity> Set<E> load(@NotNull DatabaseContext ctx, @NotNull EntityMetadata<E> metadata, @NotNull ResultSet rset)
            throws SQLException
    {
        Set<E> result = Sets.newHashSet();

        while (rset.next()) {
            E instance = metadata.createEmpty();

            for (EntityField<E> field : metadata.getFields().values()) {
                if (field.getConverter() != null) continue;
                Object value = rset.getObject(field.getColumnName());
                field.set(instance, value);
            }

            for (EntityField<E> field : metadata.getFields().values()) {
                if (field.getConverter() == null) continue;
                Object value = field.getConverter().extract(ctx, rset);
                field.set(instance, value);
            }

            result.add(instance);
        }

        return result;
    }
}
