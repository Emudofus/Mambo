

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
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
