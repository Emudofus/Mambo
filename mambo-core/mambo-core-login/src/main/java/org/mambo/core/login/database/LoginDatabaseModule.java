package org.mambo.core.login.database;

import com.google.inject.Provider;
import com.google.inject.Provides;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.login.database.model.User;
import org.mambo.shared.database.DatabaseModule;
import org.mambo.shared.database.persistence.JdbcPersistenceStrategy;
import org.mambo.shared.database.persistence.PersistenceStrategy;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:25
 */
public class LoginDatabaseModule extends DatabaseModule {
    @Override
    protected void configureRepositories() {
        bindMutableRepository(User.class);
    }

    @Provides
    @Singleton
    Connection provideConnection(ConfigurationProvider config) {
        try {
            Class.forName(config.getString("database.driver"));
            return DriverManager.getConnection(config.getString("database.url"));
        } catch (Throwable t) {
            addError(t);
            return null;
        }
    }

    @Provides
    @Singleton
    PersistenceStrategy providePersistenceStrategy(Provider<Connection> connection) {
        return new JdbcPersistenceStrategy(connection);
    }
}
