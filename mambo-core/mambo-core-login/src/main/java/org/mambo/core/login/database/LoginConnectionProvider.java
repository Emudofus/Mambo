package org.mambo.core.login.database;

import org.mambo.core.bootstrap.ServicePriority;
import org.mambo.core.bootstrap.ServicePriorityType;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.shared.database.impl.ConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 16/12/12
 * Time: 16:29
 */
@ServicePriority(ServicePriorityType.HIGH)
public class LoginConnectionProvider extends ConnectionProvider {
    private static final Logger log = LoggerFactory.getLogger(LoginConnectionProvider.class);

    @Inject
    public LoginConnectionProvider(ConfigurationProvider config) {
        super(
                config.getString("database.driver"),
                config.getString("database.url")
        );
    }

    @Override
    protected void startUp() throws Exception {
        super.startUp();

        log.info("connection established");
    }

    @Override
    protected void shutDown() throws Exception {
        super.shutDown();

        log.info("connection closed");
    }
}
