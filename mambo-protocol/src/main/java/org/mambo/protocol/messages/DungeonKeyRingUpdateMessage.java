

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonKeyRingUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6296;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public boolean available;
    
    public DungeonKeyRingUpdateMessage() { }
    
    public DungeonKeyRingUpdateMessage(short dungeonId, boolean available) {
        this.dungeonId = dungeonId;
        this.available = available;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
        buf.writeBoolean(available);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        available = buf.readBoolean();
    }
    
}
