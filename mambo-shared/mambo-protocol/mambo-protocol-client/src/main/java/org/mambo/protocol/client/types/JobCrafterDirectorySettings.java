

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobCrafterDirectorySettings implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 97;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte jobId;
    public byte minSlot;
    public byte userDefinedParams;
    
    public JobCrafterDirectorySettings() { }
    
    public JobCrafterDirectorySettings(byte jobId, byte minSlot, byte userDefinedParams) {
        this.jobId = jobId;
        this.minSlot = minSlot;
        this.userDefinedParams = userDefinedParams;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
        writer.writeByte(minSlot);
        writer.writeByte(userDefinedParams);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        minSlot = reader.readByte();
        if (minSlot < 0 || minSlot > 9)
            throw new RuntimeException("Forbidden value on minSlot = " + minSlot + ", it doesn't respect the following condition : minSlot < 0 || minSlot > 9");
        userDefinedParams = reader.readByte();
        if (userDefinedParams < 0)
            throw new RuntimeException("Forbidden value on userDefinedParams = " + userDefinedParams + ", it doesn't respect the following condition : userDefinedParams < 0");
    }
    
}
