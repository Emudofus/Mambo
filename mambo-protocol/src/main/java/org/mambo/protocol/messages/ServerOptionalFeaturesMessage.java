

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(features.length);
        for (short entry : features) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        features = new short[limit];
        for (int i = 0; i < limit; i++) {
            features[i] = buf.readShort();
        }
    }
    
}
