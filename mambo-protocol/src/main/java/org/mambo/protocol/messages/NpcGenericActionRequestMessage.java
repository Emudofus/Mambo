

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class NpcGenericActionRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5898;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int npcId;
    public byte npcActionId;
    public int npcMapId;
    
    public NpcGenericActionRequestMessage() { }
    
    public NpcGenericActionRequestMessage(int npcId, byte npcActionId, int npcMapId) {
        this.npcId = npcId;
        this.npcActionId = npcActionId;
        this.npcMapId = npcMapId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(npcId);
        buf.writeByte(npcActionId);
        buf.writeInt(npcMapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        npcId = buf.readInt();
        npcActionId = buf.readByte();
        if (npcActionId < 0)
            throw new RuntimeException("Forbidden value on npcActionId = " + npcActionId + ", it doesn't respect the following condition : npcActionId < 0");
        npcMapId = buf.readInt();
    }
    
}
