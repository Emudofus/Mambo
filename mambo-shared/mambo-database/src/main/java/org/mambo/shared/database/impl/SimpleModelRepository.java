package org.mambo.shared.database.impl;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.Query;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.DatabaseContext;
import org.mambo.shared.database.ModelInterface;
import org.mambo.shared.database.ModelRepository;
import org.mambo.shared.database.PersistenceStrategy;
import org.mambo.shared.database.impl.internal.EntityField;
import org.mambo.shared.database.impl.internal.EntityMetadata;
import org.mambo.shared.database.impl.internal.References;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.googlecode.cqengine.query.QueryFactory.equal;

/**
 * a thread-safe and very simple {@link ModelRepository}
 * todo: database management
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 15:53
 */
public class SimpleModelRepository<E extends ModelInterface<?>> implements ModelRepository<E> {
    private final EntityMetadata metadata;
    private final IndexedCollection<E> entities = CQEngine.newInstance(); // thread-safe collection
    private final PersistenceStrategy persistence;

    /**
     * TODO initialize context
     */
    private DatabaseContext ctx;

    public SimpleModelRepository(@NotNull Class<E> clazz, @NotNull PersistenceStrategy persistence) {
        this.metadata = EntityMetadata.of(clazz);
        this.persistence = checkNotNull(persistence);
    }

    protected Query<E> queryId(Object id) {
        return equal(metadata.getPrimaryKeyField().<E>asAttribute(metadata), id);
    }

    protected Query<E> query(String property, Object value) {
        EntityField field = metadata.getField(property);
        if (field == null) {
            throw new IllegalArgumentException("unknown property \"" + property + "\"");
        }

        return equal(field.<E>asAttribute(metadata), value);
    }

    /**
     * {@inheritDoc}
     * @see com.googlecode.cqengine.resultset.ResultSet#size()
     */
    protected boolean isPersisted(@NotNull Object id) {
        return entities.retrieve(queryId(id)).size() == 1;
    }

    @Override
    public boolean isPersisted(@NotNull E entity) {
        return isPersisted(entity.getId());
    }

    @Override
    public void persist(@NotNull E entity) {
        if (entities.add(entity)) {
            persistence.insert(ctx, metadata, entity);
        } else {
            persistence.update(ctx, metadata, entity);
        }
    }

    @Override
    public void delete(@NotNull E entity) {
        if (!entities.remove(entity)) {
            throw new IllegalArgumentException("{" + entity + "} is not persisted");
        }

        persistence.delete(ctx, metadata, entity);
    }

    @NotNull
    @Override
    public E delete(@NotNull Object id) {
        E entity = find(id);
        if (entity == null || !entities.remove(entity)) {
            throw new IllegalArgumentException("unknown id=" + id);
        }

        persistence.delete(ctx, metadata, entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public E createEmpty() {
        return (E) metadata.createEmpty();
    }

    @NotNull
    @Override
    public E createWithValues(Function<E, Void> initializer) {
        E entity = createEmpty();
        initializer.apply(entity);
        return entity;
    }

    /**
     * {@inheritDoc}
     * @see com.googlecode.cqengine.resultset.ResultSet#uniqueResult()
     */
    @Override
    public E find(@NotNull Object id) {
        return entities.retrieve(queryId(id)).uniqueResult();
    }

    /**
     * {@inheritDoc}
     * @see com.googlecode.cqengine.resultset.ResultSet#uniqueResult()
     */
    @Override
    public E find(@NotNull String property, Object value) {
        Query<E> query = query(property, value);
        return entities.retrieve(query).uniqueResult();
    }

    @Override
    public List<E> findAll(@NotNull String property, Object value) {
        Query<E> query = query(property, value);
        return ImmutableList.copyOf(entities.retrieve(query));
    }

    @Override
    public E getReference(@NotNull Object id) {
        return References.create(this, metadata, id);
    }
}
