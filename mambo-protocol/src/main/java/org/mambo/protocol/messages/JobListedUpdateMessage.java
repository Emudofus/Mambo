

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobListedUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6016;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean addedOrDeleted;
    public byte jobId;
    
    public JobListedUpdateMessage() { }
    
    public JobListedUpdateMessage(boolean addedOrDeleted, byte jobId) {
        this.addedOrDeleted = addedOrDeleted;
        this.jobId = jobId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(addedOrDeleted);
        buf.writeByte(jobId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        addedOrDeleted = buf.readBoolean();
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
    }
    
}
