

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SkillActionDescription extends NetworkType {
    public static final short TYPE_ID = 102;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short skillId;
    
    public SkillActionDescription() { }
    
    public SkillActionDescription(short skillId) {
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(skillId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        skillId = buf.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
