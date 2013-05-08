

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderRegisterRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6249;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] dungeonIds;
    
    public DungeonPartyFinderRegisterRequestMessage() { }
    
    public DungeonPartyFinderRegisterRequestMessage(short[] dungeonIds) {
        this.dungeonIds = dungeonIds;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(dungeonIds.length);
        for (short entry : dungeonIds) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        dungeonIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            dungeonIds[i] = buf.readShort();
        }
    }
    
}
