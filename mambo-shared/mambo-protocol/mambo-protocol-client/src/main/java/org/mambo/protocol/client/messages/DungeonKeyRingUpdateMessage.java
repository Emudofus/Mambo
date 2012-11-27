

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeBoolean(available);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        available = reader.readBoolean();
    }
    
}
