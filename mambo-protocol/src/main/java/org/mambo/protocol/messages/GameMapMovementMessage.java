

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameMapMovementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 951;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] keyMovements;
    public int actorId;
    
    public GameMapMovementMessage() { }
    
    public GameMapMovementMessage(short[] keyMovements, int actorId) {
        this.keyMovements = keyMovements;
        this.actorId = actorId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(keyMovements.length);
        for (short entry : keyMovements) {
            buf.writeShort(entry);
        }
        buf.writeInt(actorId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        keyMovements = new short[limit];
        for (int i = 0; i < limit; i++) {
            keyMovements[i] = buf.readShort();
        }
        actorId = buf.readInt();
    }
    
}
