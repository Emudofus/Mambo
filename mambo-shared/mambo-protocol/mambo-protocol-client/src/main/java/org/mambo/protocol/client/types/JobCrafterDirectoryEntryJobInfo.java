

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryJobInfo implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 195;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
        writer.writeByte(jobLevel);
        writer.writeByte(userDefinedParams);
        writer.writeByte(minSlots);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        jobLevel = reader.readByte();
        if (jobLevel < 1 || jobLevel > 100)
            throw new RuntimeException("Forbidden value on jobLevel = " + jobLevel + ", it doesn't respect the following condition : jobLevel < 1 || jobLevel > 100");
        userDefinedParams = reader.readByte();
        if (userDefinedParams < 0)
            throw new RuntimeException("Forbidden value on userDefinedParams = " + userDefinedParams + ", it doesn't respect the following condition : userDefinedParams < 0");
        minSlots = reader.readByte();
        if (minSlots < 0 || minSlots > 9)
            throw new RuntimeException("Forbidden value on minSlots = " + minSlots + ", it doesn't respect the following condition : minSlots < 0 || minSlots > 9");
    }
    
}
