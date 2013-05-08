

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
