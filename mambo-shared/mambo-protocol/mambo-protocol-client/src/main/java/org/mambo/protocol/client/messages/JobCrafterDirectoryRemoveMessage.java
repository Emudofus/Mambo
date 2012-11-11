

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobCrafterDirectoryRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5653;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte jobId;
    public int playerId;
    
    public JobCrafterDirectoryRemoveMessage() { }
    
    public JobCrafterDirectoryRemoveMessage(byte jobId, int playerId) {
        this.jobId = jobId;
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
        writer.writeInt(playerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
