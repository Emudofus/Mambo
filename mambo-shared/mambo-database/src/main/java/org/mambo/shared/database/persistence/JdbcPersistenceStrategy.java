package org.mambo.shared.database.persistence;

import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.impl.internal.EntityMetadata;

import javax.inject.Provider;
import java.sql.Connection;
import java.util.Set;

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

    @NotNull
    @Override
    public <E extends Entity> Set<E> load(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata) {
        return Sets.newHashSet(); // TODO
    }

    @Override
    public <E extends Entity> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }

    @Override
    public <E extends Entity> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }

    @Override
    public <E extends Entity> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity) {
        // TODO
    }
}
