

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobUnlearntMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5657;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte jobId;
    
    public JobUnlearntMessage() { }
    
    public JobUnlearntMessage(byte jobId) {
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
