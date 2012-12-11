package org.mambo.core.login.database;

import com.google.inject.Scopes;
import org.mambo.core.login.database.model.User;
import org.mambo.shared.database.DatabaseModule;
import org.mambo.shared.database.PersistenceStrategy;
import org.mambo.shared.database.impl.JdbcPersistenceStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:25
 */
public class LoginDatabaseModule extends DatabaseModule {
    @Override
    protected void configure() {
        bind(PersistenceStrategy.class).to(JdbcPersistenceStrategy.class).in(Scopes.SINGLETON);

        super.configure();
    }

    @Override
    protected void configureRepositories() {
        bindMutableRepository(User.class);
    }
}
