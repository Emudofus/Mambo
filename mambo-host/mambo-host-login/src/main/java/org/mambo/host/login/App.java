package org.mambo.host.login;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import org.mambo.core.bootstrap.ServiceBootstrap;
import org.mambo.core.bootstrap.ServiceBootstrapModule;
import org.mambo.core.configuration.ConfigurationProvider;
import org.mambo.core.configuration.ConfigurationProviderModule;
import org.mambo.core.configuration.XmlConfigurationProvider;
import org.mambo.core.login.service.login.NettyLoginServiceModule;
import org.mambo.core.login.service.login.handler.LoginHandlerModule;
import org.mambo.core.parser.string.StringParsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ConfigurationProvider configuration = new XmlConfigurationProvider(StringParsers.defaults());

        try {
            configuration.load(new FileInputStream("./config.xml"));
        } catch (FileNotFoundException e) {
            log.error("can't load configuration file");
            return;
        }

        Injector inject = Guice.createInjector(
                Stage.PRODUCTION,
                new ConfigurationProviderModule(configuration),
                new NettyLoginServiceModule(),
                new LoginHandlerModule(),
                new ServiceBootstrapModule()
        );

        final ServiceBootstrap bootstrap = inject.getInstance(ServiceBootstrap.class);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                bootstrap.shutdown();
            }
        });

        bootstrap.boot();
    }
}
