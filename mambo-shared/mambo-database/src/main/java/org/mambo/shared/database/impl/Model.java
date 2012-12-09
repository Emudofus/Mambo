package org.mambo.shared.database.impl;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.ModelInterface;
import org.mambo.shared.database.ModelRepository;

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
public abstract class Model<K, E extends Model<K, E>> implements ModelInterface<K> {
    @Inject
    private ModelRepository<E> repository;

    protected Model() {
    }

    protected Model(@NotNull ModelRepository<E> repository) {
        this.repository = checkNotNull(repository);
    }

    @SuppressWarnings("unchecked")
    protected E that() {
        return (E) this;
    }

    @Override
    public boolean isPersisted() {
        return repository.isPersisted(that());
    }

    @Override
    public void persist() {
        repository.persist(that());
    }

    @Override
    public void delete() {
        repository.delete(that());
    }
}
