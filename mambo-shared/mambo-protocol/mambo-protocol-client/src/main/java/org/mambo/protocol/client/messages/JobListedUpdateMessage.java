

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(addedOrDeleted);
        writer.writeByte(jobId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        addedOrDeleted = reader.readBoolean();
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
    }
    
}
