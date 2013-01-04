

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ServerOptionalFeaturesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6305;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] features;
    
    public ServerOptionalFeaturesMessage() { }
    
    public ServerOptionalFeaturesMessage(short[] features) {
        this.features = features;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(features.length);
        for (short entry : features) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        features = new short[limit];
        for (int i = 0; i < limit; i++) {
            features[i] = reader.readShort();
        }
    }
    
}
