package org.mambo.protocol;

import org.mambo.core.io.Buffer;

/**
 * @author Blackrush
 */
public interface Serializable {
    void serialize(Buffer buf);
    void deserialize(Buffer buf);
}
