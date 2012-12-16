package org.mambo.core.configuration;

import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.List;

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

        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                final List<FieldToConfigKey> entries = Lists.newArrayList();

                for (Field field : type.getRawType().getDeclaredFields()) {
                    InjectConfig annotation = field.getAnnotation(InjectConfig.class);
                    if (annotation == null) continue;

                    field.setAccessible(true);
                    entries.add(new FieldToConfigKey(field, annotation));
                }
                if (entries.size() <= 0) return;

                encounter.register(new MembersInjector<I>() {
                    public void injectMembers(I instance) {
                        for (FieldToConfigKey entry : entries) {
                            try {
                                entry.field.set(instance, configuration.get(entry.configKey.value()));
                            } catch (IllegalAccessException e) {
                                addError(e);
                            }
                        }
                    }
                });
            }
        });
    }

    private static class FieldToConfigKey {
        private final Field field;
        private final InjectConfig configKey;

        private FieldToConfigKey(Field field, InjectConfig configKey) {
            this.field = field;
            this.configKey = configKey;
        }
    }
}
