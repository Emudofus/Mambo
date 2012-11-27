

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SkillActionDescription implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 102;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short skillId;
    
    public SkillActionDescription() { }
    
    public SkillActionDescription(short skillId) {
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(skillId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        skillId = reader.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
