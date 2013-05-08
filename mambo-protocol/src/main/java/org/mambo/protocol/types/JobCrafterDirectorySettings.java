

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectorySettings extends NetworkType {
    public static final short TYPE_ID = 97;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
        buf.writeByte(minSlot);
        buf.writeByte(userDefinedParams);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        minSlot = buf.readByte();
        if (minSlot < 0 || minSlot > 9)
            throw new RuntimeException("Forbidden value on minSlot = " + minSlot + ", it doesn't respect the following condition : minSlot < 0 || minSlot > 9");
        userDefinedParams = buf.readByte();
        if (userDefinedParams < 0)
            throw new RuntimeException("Forbidden value on userDefinedParams = " + userDefinedParams + ", it doesn't respect the following condition : userDefinedParams < 0");
    }
    
}
