

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeByte(newLevel);
        jobsDescription.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        newLevel = buf.readByte();
        if (newLevel < 0)
            throw new RuntimeException("Forbidden value on newLevel = " + newLevel + ", it doesn't respect the following condition : newLevel < 0");
        jobsDescription = new JobDescription();
        jobsDescription.deserialize(buf);
    }
    
}
