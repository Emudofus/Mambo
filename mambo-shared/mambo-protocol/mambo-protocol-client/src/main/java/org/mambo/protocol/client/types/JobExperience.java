

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobExperience implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 98;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
        writer.writeByte(jobLevel);
        writer.writeDouble(jobXP);
        writer.writeDouble(jobXpLevelFloor);
        writer.writeDouble(jobXpNextLevelFloor);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        jobLevel = reader.readByte();
        if (jobLevel < 0)
            throw new RuntimeException("Forbidden value on jobLevel = " + jobLevel + ", it doesn't respect the following condition : jobLevel < 0");
        jobXP = reader.readDouble();
        if (jobXP < 0)
            throw new RuntimeException("Forbidden value on jobXP = " + jobXP + ", it doesn't respect the following condition : jobXP < 0");
        jobXpLevelFloor = reader.readDouble();
        if (jobXpLevelFloor < 0)
            throw new RuntimeException("Forbidden value on jobXpLevelFloor = " + jobXpLevelFloor + ", it doesn't respect the following condition : jobXpLevelFloor < 0");
        jobXpNextLevelFloor = reader.readDouble();
        if (jobXpNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on jobXpNextLevelFloor = " + jobXpNextLevelFloor + ", it doesn't respect the following condition : jobXpNextLevelFloor < 0");
    }
    
}
