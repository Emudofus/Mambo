

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(npcId);
        writer.writeByte(npcActionId);
        writer.writeInt(npcMapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        npcId = reader.readInt();
        npcActionId = reader.readByte();
        if (npcActionId < 0)
            throw new RuntimeException("Forbidden value on npcActionId = " + npcActionId + ", it doesn't respect the following condition : npcActionId < 0");
        npcMapId = reader.readInt();
    }
    
}
