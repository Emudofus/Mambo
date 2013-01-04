

// Generated on 01/04/2013 14:54:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MapInformationsRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 225;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    
    public MapInformationsRequestMessage() { }
    
    public MapInformationsRequestMessage(int mapId) {
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
