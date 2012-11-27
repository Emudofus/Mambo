package org.mambo.core.configuration;

import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.joda.time.Duration;
import org.joda.time.Instant;

import java.math.BigInteger;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 10:20
 */
public abstract class BaseConfigurationProvider implements ConfigurationProvider {
    /**
     * key and value must not be null
     */
    private final Map<String, Object> values = Maps.newHashMap();

    protected void configure(@NotNull String key, @NotNull Object value) {
        values.put(checkNotNull(key), checkNotNull(value));
    }

    protected Object getUnsafe(@NotNull String key) {
        return values.get(key);
    }

    @NotNull
    @Override
    public Object get(@NotNull String key) {
        Object value = getUnsafe(key);
        if (value == null) {
            throw new KeyNotFoundException(key);
        }
        return value;
    }

    @NotNull
    @Override
    public Object get(@NotNull String key, @NotNull Object defaultz) {
        Object value = getUnsafe(key);
        return value != null ?
                value :
                defaultz;
    }

    @Override
    public short getShort(@NotNull String key) {
        return ((Number) get(key)).shortValue();
    }

    @Override
    public short getShort(@NotNull String key, short defaultz) {
        Number value = (Number) getUnsafe(key);
        return value != null ?
                value.shortValue() :
                defaultz;
    }

    @Override
    public short getShort(@NotNull String key, int defaultz) {
        return getShort(key, (short) defaultz);
    }

    @Override
    public int getInt(@NotNull String key) {
        return ((Number) get(key)).intValue();
    }

    @Override
    public int getInt(@NotNull String key, int defaultz) {
        Number value = (Number) getUnsafe(key);
        return value != null ?
                value.intValue() :
                defaultz;
    }

    @Override
    public long getLong(@NotNull String key) {
        return ((Number) get(key)).longValue();
    }

    @Override
    public long getLong(@NotNull String key, long defaultz) {
        Number value = (Number) getUnsafe(key);
        return value != null ?
                value.longValue() :
                defaultz;
    }

    @NotNull
    @Override
    public BigInteger getBigInteger(@NotNull String key) {
        return (BigInteger) get(key);
    }

    @NotNull
    @Override
    public BigInteger getBigInteger(@NotNull String key, @NotNull BigInteger defaultz) {
        return (BigInteger) get(key, defaultz);
    }

    @NotNull
    @Override
    public String getString(@NotNull String key) {
        return (String) get(key);
    }

    @NotNull
    @Override
    public String getString(@NotNull String key, @NotNull String defaultz) {
        return (String) get(key, defaultz);
    }

    @NotNull
    @Override
    public Instant getInstant(@NotNull String key) {
        return (Instant) get(key);
    }

    @NotNull
    @Override
    public Instant getInstant(@NotNull String key, @NotNull Instant defaultz) {
        return (Instant) get(key, defaultz);
    }

    @NotNull
    @Override
    public Duration getDuration(@NotNull String key) {
        return (Duration) get(key);
    }

    @NotNull
    @Override
    public Duration getDuration(@NotNull String key, @NotNull Instant defaultz) {
        return (Duration) get(key, defaultz);
    }
}
