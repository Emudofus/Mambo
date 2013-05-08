

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryJobInfo extends NetworkType {
    public static final short TYPE_ID = 195;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte jobId;
    public byte jobLevel;
    public byte userDefinedParams;
    public byte minSlots;
    
    public JobCrafterDirectoryEntryJobInfo() { }
    
    public JobCrafterDirectoryEntryJobInfo(byte jobId, byte jobLevel, byte userDefinedParams, byte minSlots) {
        this.jobId = jobId;
        this.jobLevel = jobLevel;
        this.userDefinedParams = userDefinedParams;
        this.minSlots = minSlots;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
        buf.writeByte(jobLevel);
        buf.writeByte(userDefinedParams);
        buf.writeByte(minSlots);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        jobLevel = buf.readByte();
        if (jobLevel < 1 || jobLevel > 100)
            throw new RuntimeException("Forbidden value on jobLevel = " + jobLevel + ", it doesn't respect the following condition : jobLevel < 1 || jobLevel > 100");
        userDefinedParams = buf.readByte();
        if (userDefinedParams < 0)
            throw new RuntimeException("Forbidden value on userDefinedParams = " + userDefinedParams + ", it doesn't respect the following condition : userDefinedParams < 0");
        minSlots = buf.readByte();
        if (minSlots < 0 || minSlots > 9)
            throw new RuntimeException("Forbidden value on minSlots = " + minSlots + ", it doesn't respect the following condition : minSlots < 0 || minSlots > 9");
    }
    
}
