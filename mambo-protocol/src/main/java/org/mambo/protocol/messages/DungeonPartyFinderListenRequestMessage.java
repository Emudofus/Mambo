

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderListenRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6246;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    
    public DungeonPartyFinderListenRequestMessage() { }
    
    public DungeonPartyFinderListenRequestMessage(short dungeonId) {
        this.dungeonId = dungeonId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
