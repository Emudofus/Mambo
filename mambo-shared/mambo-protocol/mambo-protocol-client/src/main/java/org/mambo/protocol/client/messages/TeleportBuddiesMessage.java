

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
