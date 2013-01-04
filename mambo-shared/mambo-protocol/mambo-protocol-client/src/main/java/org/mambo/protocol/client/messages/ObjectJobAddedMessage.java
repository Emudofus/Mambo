

// Generated on 01/04/2013 14:54:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectJobAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6014;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte jobId;
    
    public ObjectJobAddedMessage() { }
    
    public ObjectJobAddedMessage(byte jobId) {
        this.jobId = jobId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
    }
    
}
