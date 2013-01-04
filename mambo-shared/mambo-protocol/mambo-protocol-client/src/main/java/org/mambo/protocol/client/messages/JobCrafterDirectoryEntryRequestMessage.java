

// Generated on 01/04/2013 14:54:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6043;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    
    public JobCrafterDirectoryEntryRequestMessage() { }
    
    public JobCrafterDirectoryEntryRequestMessage(int playerId) {
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
