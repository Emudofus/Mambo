package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.EntityInterface;
import org.mambo.shared.database.PersistenceStrategy;
import org.mambo.shared.database.impl.internal.EntityMetadata;

import javax.inject.Provider;
import java.sql.Connection;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/12/12
 * Time: 22:35
 */
public class JdbcPersistenceStrategy implements PersistenceStrategy {
    private final Provider<Connection> connection;

    public JdbcPersistenceStrategy(@NotNull Provider<Connection> connection) {
        this.connection = checkNotNull(connection);
    }

    @Override
    public <E extends EntityInterface<?>> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }

    @Override
    public <E extends EntityInterface<?>> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }

    @Override
    public <E extends EntityInterface<?>> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }
}
