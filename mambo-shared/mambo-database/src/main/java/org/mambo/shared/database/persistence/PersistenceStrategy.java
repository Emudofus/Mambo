package org.mambo.shared.database.persistence;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.impl.internal.EntityMetadata;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/12/12
 * Time: 22:32
 */
public interface PersistenceStrategy {
    /**
     * load all entities
     * @param ctx context
     * @param metadata entities' metadata
     * @param <E> entity's type
     * @return loaded entities
     */
    @NotNull
    <E extends Entity> Set<E> load(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata);

    /**
     * insert entity's data
     * @param ctx context
     * @param metadata entities' metadata
     * @param entity entity to insert
     * @param <E> entity's type
     */
    <E extends Entity> void insert(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);

    /**
     * update entity's data
     * @param ctx context
     * @param metadata entities' metadata
     * @param entity entity to update
     * @param <E> entity's type
     */
    <E extends Entity> void update(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);

    /**
     * delete entity
     * @param ctx context
     * @param metadata entities' metadata
     * @param entity entity to delete
     * @param <E> entity's type
     */
    <E extends Entity> void delete(@NotNull DatabaseContext ctx, @NotNull EntityMetadata metadata, @NotNull E entity);
}
