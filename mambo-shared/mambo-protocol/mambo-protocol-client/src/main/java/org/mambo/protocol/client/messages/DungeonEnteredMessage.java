

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DungeonEnteredMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6152;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int dungeonId;
    
    public DungeonEnteredMessage() { }
    
    public DungeonEnteredMessage(int dungeonId) {
        this.dungeonId = dungeonId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(dungeonId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readInt();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
