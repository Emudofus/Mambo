package org.mambo.protocol.client;

import org.mambo.core.io.DataReaderInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 22:52
 */
public interface DeserializerInterface {
    void deserialize(DataReaderInterface reader);
}
