package org.mambo.core.login.database;

import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.mambo.core.login.database.model.User;
import org.mambo.shared.database.DatabaseModule;
import org.mambo.shared.database.persistence.JdbcPersistenceStrategy;
import org.mambo.shared.database.persistence.PersistenceStrategy;

import javax.inject.Singleton;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:25
 */
public class LoginDatabaseModule extends DatabaseModule {
    @Override
    protected void configure() {
        bind(Connection.class).toProvider(LoginConnectionProvider.class).in(Scopes.SINGLETON);
        super.configure();
    }

    @Override
    protected void configureRepositories() {
        bindMutableRepository(User.class);
    }

    @Provides
    @Singleton
    PersistenceStrategy providePersistenceStrategy(Provider<Connection> connection) {
        return new JdbcPersistenceStrategy(connection);
    }
}
