package org.mambo.core.configuration;

import com.google.inject.AbstractModule;
import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 28/11/12
 * Time: 13:31
 */
public class ConfigurationProviderModule extends AbstractModule {
    private final ConfigurationProvider configuration;

    public ConfigurationProviderModule(@NotNull ConfigurationProvider configuration) {
        this.configuration = checkNotNull(configuration);
    }

    @Override
    protected void configure() {
        bind(ConfigurationProvider.class).toInstance(configuration);
    }
}
