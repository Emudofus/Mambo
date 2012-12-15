package org.mambo.shared.database.impl;

import com.google.common.collect.ImmutableList;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.unique.UniqueIndex;
import com.googlecode.cqengine.query.QueryFactory;
import com.googlecode.cqengine.resultset.ResultSet;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.Entity;
import org.mambo.shared.database.Repository;
import org.mambo.shared.database.impl.internal.EntityField;
import org.mambo.shared.database.impl.internal.EntityMetadata;
import org.mambo.shared.database.impl.internal.References;

import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * a thread-safe and very simple {@link org.mambo.shared.database.Repository}
 *
 * @see CQEngine
 * @author Blackrush
 *         Mambo
 */
public class SimpleRepository<E extends Entity> implements Repository<E> {
    private final DatabaseContext ctx;
    private final EntityMetadata<E> metadata;
    private final IndexedCollection<E> entities;

    public SimpleRepository(@NotNull DatabaseContext ctx, @NotNull Class<E> entityClass) {
        this.ctx = checkNotNull(ctx);
        this.metadata = EntityMetadata.of(entityClass);
        this.entities = CQEngine.newInstance();
    }

    @Override
    public void load() {
        entities.addIndex(UniqueIndex.onAttribute(metadata.getPrimaryKeyField().asAttribute()));

        Set<E> loaded = ctx.getPersistenceStrategy().load(ctx, metadata);
        entities.addAll(loaded);
    }

    @NotNull
    protected DatabaseContext getDatabaseContext() {
        return ctx;
    }

    @NotNull
    protected IndexedCollection<E> getEntities() {
        return entities;
    }

    @NotNull
    @Override
    public EntityMetadata<E> getEntityMetadata() {
        return metadata;
    }

    @NotNull
    protected ResultSet<E> find(@NotNull EntityField<E> field, Object value) {
        return entities.retrieve(QueryFactory.equal(field.asAttribute(), value));
    }

    @NotNull
    @Override
    public E find(@NotNull Object id) {
        return find(metadata.getPrimaryKeyField(), id).uniqueResult();
    }

    @NotNull
    @Override
    public E find(@NotNull String property, Object value) {
        EntityField<E> field = metadata.getField(property);
        if (field == null) {
            throw new IllegalArgumentException("unknown property \"" + property + "\"");
        }

        return find(field, value).uniqueResult();
    }

    @NotNull
    @Override
    public List<E> findAll(@NotNull String property, Object value) {
        EntityField<E> field = metadata.getField(property);
        if (field == null) {
            throw new IllegalArgumentException("unknown property \"" + property + "\"");
        }

        return ImmutableList.copyOf(find(field, value));
    }

    @NotNull
    @Override
    public E getReference(@NotNull Object id) {
        return References.create(this, id);
    }
}
