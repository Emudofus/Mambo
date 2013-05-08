

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(keyMovements.length);
        for (short entry : keyMovements) {
            buf.writeShort(entry);
        }
        buf.writeInt(mapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        keyMovements = new short[limit];
        for (int i = 0; i < limit; i++) {
            keyMovements[i] = buf.readShort();
        }
        mapId = buf.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
    }
    
}
