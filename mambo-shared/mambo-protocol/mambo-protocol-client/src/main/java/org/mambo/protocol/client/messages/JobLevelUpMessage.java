

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobLevelUpMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5656;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte newLevel;
    public JobDescription jobsDescription;
    
    public JobLevelUpMessage() { }
    
    public JobLevelUpMessage(byte newLevel, JobDescription jobsDescription) {
        this.newLevel = newLevel;
        this.jobsDescription = jobsDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(newLevel);
        jobsDescription.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        newLevel = reader.readByte();
        if (newLevel < 0)
            throw new RuntimeException("Forbidden value on newLevel = " + newLevel + ", it doesn't respect the following condition : newLevel < 0");
        jobsDescription = new JobDescription();
        jobsDescription.deserialize(reader);
    }
    
}
