

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameMapMovementRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 950;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] keyMovements;
    public int mapId;
    
    public GameMapMovementRequestMessage() { }
    
    public GameMapMovementRequestMessage(short[] keyMovements, int mapId) {
        this.keyMovements = keyMovements;
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(keyMovements.length);
        for (short entry : keyMovements) {
            writer.writeShort(entry);
        }
        writer.writeInt(mapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        keyMovements = new short[limit];
        for (int i = 0; i < limit; i++) {
            keyMovements[i] = reader.readShort();
        }
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
