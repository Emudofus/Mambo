package org.mambo.shared.database;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:26
 */
public abstract class DatabaseModule extends AbstractModule {
    protected abstract void configureRepositories();

    @Override
    protected void configure() {
        configureRepositories();
    }

    protected <E extends Entity, R extends Repository<E>> void bindRepository(TypeLiteral<R> repository) {
        bind(new TypeLiteral<Repository<E>>(){}).to(repository).in(Singleton.class);
    }
}
