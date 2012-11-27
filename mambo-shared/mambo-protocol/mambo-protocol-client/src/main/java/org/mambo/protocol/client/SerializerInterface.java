package org.mambo.protocol.client;

import org.mambo.core.io.DataWriterInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 22:51
 */
public interface SerializerInterface {
    void serialize(DataWriterInterface writer);
}
