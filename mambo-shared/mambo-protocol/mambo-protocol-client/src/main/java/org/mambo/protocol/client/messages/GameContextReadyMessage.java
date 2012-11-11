

// Generated on 11/11/2012 19:17:00
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameContextReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6071;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    
    public GameContextReadyMessage() { }
    
    public GameContextReadyMessage(int mapId) {
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(mapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
