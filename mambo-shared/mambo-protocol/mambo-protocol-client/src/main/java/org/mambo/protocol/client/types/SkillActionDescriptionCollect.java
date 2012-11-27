

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class SkillActionDescriptionCollect extends SkillActionDescriptionTimed {
    public static final short TYPE_ID = 99;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short min;
    public short max;
    
    public SkillActionDescriptionCollect() { }
    
    public SkillActionDescriptionCollect(short skillId, short time, short min, short max) {
        super(skillId, time);
        this.min = min;
        this.max = max;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(min);
        writer.writeShort(max);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        min = reader.readShort();
        if (min < 0)
            throw new RuntimeException("Forbidden value on min = " + min + ", it doesn't respect the following condition : min < 0");
        max = reader.readShort();
        if (max < 0)
            throw new RuntimeException("Forbidden value on max = " + max + ", it doesn't respect the following condition : max < 0");
    }
    
}
