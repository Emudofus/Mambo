

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveElementSkill extends NetworkType {
    public static final short TYPE_ID = 219;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(skillId);
        buf.writeInt(skillInstanceUid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        skillId = buf.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
        skillInstanceUid = buf.readInt();
        if (skillInstanceUid < 0)
            throw new RuntimeException("Forbidden value on skillInstanceUid = " + skillInstanceUid + ", it doesn't respect the following condition : skillInstanceUid < 0");
    }
    
}
