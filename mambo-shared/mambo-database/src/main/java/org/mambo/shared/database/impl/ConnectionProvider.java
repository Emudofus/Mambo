package org.mambo.shared.database.impl;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.inject.Provider;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Blackrush
 *         Mambo
 */
public class ConnectionProvider extends AbstractIdleService implements Provider<Connection> {
    private final String driver;
    private final String url;

    private Connection connection;

    public ConnectionProvider(String driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    @Override
    protected void startUp() throws Exception {
        Class.forName(driver);
        connection = DriverManager.getConnection(url);
    }

    @Override
    protected void shutDown() throws Exception {
        connection.close();
    }

    @Override
    public Connection get() {
        return connection;
    }
}
