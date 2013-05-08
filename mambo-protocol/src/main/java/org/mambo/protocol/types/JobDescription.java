

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobDescription extends NetworkType {
    public static final short TYPE_ID = 101;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeByte(jobId);
        buf.writeUShort(skills.length);
        for (SkillActionDescription entry : skills) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        jobId = buf.readByte();
        if (jobId < 0)
            throw new RuntimeException("Forbidden value on jobId = " + jobId + ", it doesn't respect the following condition : jobId < 0");
        int limit = buf.readUShort();
        skills = new SkillActionDescription[limit];
        for (int i = 0; i < limit; i++) {
            skills[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            skills[i].deserialize(buf);
        }
    }
    
}
