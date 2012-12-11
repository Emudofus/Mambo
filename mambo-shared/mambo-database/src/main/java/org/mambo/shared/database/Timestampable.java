package org.mambo.shared.database;

import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;

/**
 * can be converted to a mixin with Java 8
 *
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 11/12/12
 * Time: 18:15
 */
public interface Timestampable {
    /**
     * instantiation date
     * @return non-null {@link Instant}
     */
    @NotNull
    Instant getCreatedAt();

    /**
     * persistence date
     * @return null if this entity has never been persisted
     */
    Instant getPersistedAt();

    /**
     * deletion date
     * @return non-null if this entity has been deleted
     */
    Instant getDeletedAt();
}
