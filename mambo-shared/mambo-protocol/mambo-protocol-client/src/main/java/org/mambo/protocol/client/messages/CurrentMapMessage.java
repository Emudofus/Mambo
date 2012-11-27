

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CurrentMapMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 220;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    public String mapKey;
    
    public CurrentMapMessage() { }
    
    public CurrentMapMessage(int mapId, String mapKey) {
        this.mapId = mapId;
        this.mapKey = mapKey;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mapId);
        writer.writeString(mapKey);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
        mapKey = reader.readString();
    }
    
}
