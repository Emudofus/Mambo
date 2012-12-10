package org.mambo.shared.database;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.impl.BigIntegerGenerator;
import org.mambo.shared.database.impl.IntegerGenerator;
import org.mambo.shared.database.impl.LongGenerator;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 08/12/12
 * Time: 23:23
 */
public final class PrimaryKeyGenerators {
    private PrimaryKeyGenerators() {}

    private static final Map<TypeToken<?>, PrimaryKeyGenerator<?>> generators = ImmutableMap.<TypeToken<?>, PrimaryKeyGenerator<?>>builder()
            .put(TypeToken.of(Integer.class), new IntegerGenerator())
            .put(TypeToken.of(Long.class), new LongGenerator())
            .put(TypeToken.of(BigInteger.class), new BigIntegerGenerator())
            .build();

    /**
     * returns an instance of {@link PrimaryKeyGenerator} by a {@link TypeToken}
     * @param typeToken non-null keys' type
     * @param <K> keys' type
     * @return {@link PrimaryKeyGenerator} instance or null if not found
     */
    @SuppressWarnings("unchecked")
    public static <K> PrimaryKeyGenerator<K> of(@NotNull TypeToken<K> typeToken) {
        return (PrimaryKeyGenerator<K>) generators.get(typeToken);
    }

    /**
     * returns an instance of {@link PrimaryKeyGenerator} by a {@link Class}
     * @param clazz non-null keys' class
     * @param <K> keys' type
     * @return {@link PrimaryKeyGenerator} instance or null if not found
     */
    public static <K> PrimaryKeyGenerator<K> of(@NotNull Class<K> clazz) {
        return of(TypeToken.of(clazz));
    }
}
