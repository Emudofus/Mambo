

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SkillActionDescriptionTimed extends SkillActionDescription {
    public static final short TYPE_ID = 103;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short time;
    
    public SkillActionDescriptionTimed() { }
    
    public SkillActionDescriptionTimed(short skillId, short time) {
        super(skillId);
        this.time = time;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(time);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        time = buf.readUByte();
        if (time < 0 || time > 255)
            throw new RuntimeException("Forbidden value on time = " + time + ", it doesn't respect the following condition : time < 0 || time > 255");
    }
    
}
