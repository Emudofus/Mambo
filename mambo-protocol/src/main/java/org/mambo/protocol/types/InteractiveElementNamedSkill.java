

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveElementNamedSkill extends InteractiveElementSkill {
    public static final short TYPE_ID = 220;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int nameId;
    
    public InteractiveElementNamedSkill() { }
    
    public InteractiveElementNamedSkill(int skillId, int skillInstanceUid, int nameId) {
        super(skillId, skillInstanceUid);
        this.nameId = nameId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(nameId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        nameId = buf.readInt();
        if (nameId < 0)
            throw new RuntimeException("Forbidden value on nameId = " + nameId + ", it doesn't respect the following condition : nameId < 0");
    }
    
}
