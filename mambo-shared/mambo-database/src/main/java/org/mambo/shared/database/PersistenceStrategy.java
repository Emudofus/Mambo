package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.impl.internal.EntityMetadata;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/12/12
 * Time: 22:32
 */
public interface PersistenceStrategy {
    <E extends EntityInterface<?>> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);
    <E extends EntityInterface<?>> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);
    <E extends EntityInterface<?>> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);
}
