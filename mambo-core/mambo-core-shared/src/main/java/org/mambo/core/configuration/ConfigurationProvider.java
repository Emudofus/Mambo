package org.mambo.core.configuration;

import org.jetbrains.annotations.NotNull;
import org.joda.time.Duration;
import org.joda.time.Instant;

import java.io.InputStream;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 10:15
 */
public interface ConfigurationProvider {
    /**
     * @param input input
     * @throws ConfigurationLoadException thrown if load has failed
     */
    void load(@NotNull InputStream input);

    @NotNull
    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    Object get(@NotNull String key);
    @NotNull
    Object get(@NotNull String key, @NotNull Object defaultz);

    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    short getShort(@NotNull String key);
    short getShort(@NotNull String key, short defaultz);
    short getShort(@NotNull String key, int defaultz);

    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    int getInt(@NotNull String key);
    int getInt(@NotNull String key, int defaultz);

    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    long getLong(@NotNull String key);
    long getLong(@NotNull String key, long defaultz);

    @NotNull
    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    BigInteger getBigInteger(@NotNull String key);
    @NotNull
    BigInteger getBigInteger(@NotNull String key, @NotNull BigInteger defaultz);

    @NotNull
    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    String getString(@NotNull String key);
    @NotNull
    String getString(@NotNull String key, @NotNull String defaultz);

    @NotNull
    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    Instant getInstant(@NotNull String key);
    @NotNull
    Instant getInstant(@NotNull String key, @NotNull Instant defaultz);

    @NotNull
    /**
     * @throws KeyNotFoundException thrown if key doesn't exist
     */
    Duration getDuration(@NotNull String key);
    @NotNull
    Duration getDuration(@NotNull String key, @NotNull Instant defaultz);
}
