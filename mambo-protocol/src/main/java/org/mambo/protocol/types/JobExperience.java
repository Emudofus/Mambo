

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobExperience extends NetworkType {
    public static final short TYPE_ID = 98;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte jobId;
    public byte jobLevel;
    public double jobXP;
    public double jobXpLevelFloor;
    public double jobXpNextLevelFloor;
    
    public JobExperience() { }
    
    public JobExperience(byte jobId, byte jobLevel, double jobXP, double jobXpLevelFloor, double jobXpNextLevelFloor) {
        this.jobId = jobId;
        this.jobLevel = jobLevel;
        this.jobXP = jobXP;
        this.jobXpLevelFloor = jobXpLevelFloor;
        this.jobXpNextLevelFloor = jobXpNextLevelFloor;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
        buf.writeByte(jobLevel);
        buf.writeDouble(jobXP);
        buf.writeDouble(jobXpLevelFloor);
        buf.writeDouble(jobXpNextLevelFloor);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        jobLevel = buf.readByte();
        if (jobLevel < 0)
            throw new RuntimeException("Forbidden value on jobLevel = " + jobLevel + ", it doesn't respect the following condition : jobLevel < 0");
        jobXP = buf.readDouble();
        if (jobXP < 0)
            throw new RuntimeException("Forbidden value on jobXP = " + jobXP + ", it doesn't respect the following condition : jobXP < 0");
        jobXpLevelFloor = buf.readDouble();
        if (jobXpLevelFloor < 0)
            throw new RuntimeException("Forbidden value on jobXpLevelFloor = " + jobXpLevelFloor + ", it doesn't respect the following condition : jobXpLevelFloor < 0");
        jobXpNextLevelFloor = buf.readDouble();
        if (jobXpNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on jobXpNextLevelFloor = " + jobXpNextLevelFloor + ", it doesn't respect the following condition : jobXpNextLevelFloor < 0");
    }
    
}
