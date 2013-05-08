

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
    }
    
}
