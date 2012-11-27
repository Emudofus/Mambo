

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InteractiveElementSkill implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 219;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int skillId;
    public int skillInstanceUid;
    
    public InteractiveElementSkill() { }
    
    public InteractiveElementSkill(int skillId, int skillInstanceUid) {
        this.skillId = skillId;
        this.skillInstanceUid = skillInstanceUid;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(skillId);
        writer.writeInt(skillInstanceUid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        skillId = reader.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
        skillInstanceUid = reader.readInt();
        if (skillInstanceUid < 0)
            throw new RuntimeException("Forbidden value on skillInstanceUid = " + skillInstanceUid + ", it doesn't respect the following condition : skillInstanceUid < 0");
    }
    
}
