

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportBuddiesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6289;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    
    public TeleportBuddiesMessage() { }
    
    public TeleportBuddiesMessage(short dungeonId) {
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
