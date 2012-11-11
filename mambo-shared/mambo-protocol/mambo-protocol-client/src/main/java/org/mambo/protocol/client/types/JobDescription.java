

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobDescription implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 101;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte jobId;
    public SkillActionDescription[] skills;
    
    public JobDescription() { }
    
    public JobDescription(byte jobId, SkillActionDescription[] skills) {
        this.jobId = jobId;
        this.skills = skills;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(jobId);
        writer.writeUnsignedShort(skills.length);
        for (SkillActionDescription entry : skills) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        jobId = reader.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        int limit = reader.readUnsignedShort();
        skills = new SkillActionDescription[limit];
        for (int i = 0; i < limit; i++) {
            skills[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), SkillActionDescription.class);
            skills[i].deserialize(reader);
        }
    }
    
}
