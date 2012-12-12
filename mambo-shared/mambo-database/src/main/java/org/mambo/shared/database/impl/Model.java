package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
import org.mambo.shared.database.MutableEntity;
import org.mambo.shared.database.MutableRepository;
import org.mambo.shared.database.Timestampable;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * use Guice
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:09
 */
public abstract class Model<E extends Model<E>> implements MutableEntity, Timestampable {
    @Inject
    private MutableRepository<E> repository;

    private final Instant createdAt;
    private Instant persistedAt, deletedAt;

    protected Model() {
        createdAt = Instant.now();
    }

    @SuppressWarnings("unchecked")
    protected E that() {
        return (E) this;
    }

    protected void setRepository(@NotNull MutableRepository<E> repository) {
        this.repository = checkNotNull(repository);
    }

    @Override
    public boolean isPersisted() {
        return repository.isPersisted(that());
    }

    @Override
    public void persist() {
        repository.persist(that());
        persistedAt = Instant.now();
    }

    @Override
    public void delete() {
        repository.delete(that());
        deletedAt = Instant.now();
    }

    @NotNull
    @Override
    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public Instant getPersistedAt() {
        return persistedAt;
    }

    /**
     * @param persistedAt nullable
     */
    protected void setPersistedAt(Instant persistedAt) {
        this.persistedAt = persistedAt;
    }

    @Override
    public Instant getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt nullable
     */
    protected void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
}
