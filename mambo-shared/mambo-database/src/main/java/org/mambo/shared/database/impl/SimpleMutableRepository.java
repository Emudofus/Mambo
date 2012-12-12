package org.mambo.shared.database.impl;

import com.google.common.base.Function;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.*;
import org.mambo.shared.database.persistence.PersistenceStrategy;

/**
 * {@link MutableRepository} version of {@link SimpleRepository}
 * @see PrimaryKeyGenerator
 * @see com.googlecode.cqengine.CQEngine
 *
 * @author Blackrush
 *         Mambo
 */
public class SimpleMutableRepository<E extends MutableEntity> extends SimpleRepository<E> implements MutableRepository<E> {
    private final PrimaryKeyGenerator<?> primaryKeyGenerator;

    public SimpleMutableRepository(@NotNull DatabaseContext ctx, @NotNull Class<E> entityClass) {
        super(ctx, entityClass);
        this.primaryKeyGenerator = PrimaryKeyGenerators.of(getEntityMetadata().getPrimaryKeyField().getType());
    }

    @Override
    public void load() {
        super.load();

        primaryKeyGenerator.initialize(getEntities());
    }

    @NotNull
    protected PersistenceStrategy getPersistenceStrategy() {
        return getDatabaseContext().getPersistenceStrategy();
    }

    protected boolean isPersisted(@NotNull Object id) {
        return find(getEntityMetadata().getPrimaryKeyField(), id).size() == 1;
    }

    @Override
    public boolean isPersisted(@NotNull E entity) {
        return isPersisted(entity.getId());
    }

    @Override
    public void persist(@NotNull E entity) {
        if (!isPersisted(entity)) {
            entity.setId(primaryKeyGenerator.next());
            getEntities().add(entity);
            getPersistenceStrategy().insert(getDatabaseContext(), getEntityMetadata(), entity);
        } else {
            getPersistenceStrategy().update(getDatabaseContext(), getEntityMetadata(), entity);
        }
    }

    @Override
    public void delete(@NotNull E entity) {
        if (!isPersisted(entity)) {
            throw new IllegalArgumentException("{" + entity + "} is not persisted");
        }

        getEntities().remove(entity);
        getPersistenceStrategy().delete(getDatabaseContext(), getEntityMetadata(), entity);
    }

    @NotNull
    @Override
    public E delete(@NotNull Object id) {
        E entity = find(id); // non-null

        getEntities().remove(entity);
        getPersistenceStrategy().delete(getDatabaseContext(), getEntityMetadata(), entity);

        return entity;
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public E createEmpty() {
        return (E) getEntityMetadata().createEmpty();
    }

    @NotNull
    @Override
    public E createWithValues(Function<E, Void> initializer) {
        E entity = createEmpty();
        initializer.apply(entity);
        return entity;
    }
}
