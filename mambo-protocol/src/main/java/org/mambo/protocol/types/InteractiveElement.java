

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveElement extends NetworkType {
    public static final short TYPE_ID = 80;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int elementId;
    public int elementTypeId;
    public InteractiveElementSkill[] enabledSkills;
    public InteractiveElementSkill[] disabledSkills;
    
    public InteractiveElement() { }
    
    public InteractiveElement(int elementId, int elementTypeId, InteractiveElementSkill[] enabledSkills, InteractiveElementSkill[] disabledSkills) {
        this.elementId = elementId;
        this.elementTypeId = elementTypeId;
        this.enabledSkills = enabledSkills;
        this.disabledSkills = disabledSkills;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(elementId);
        buf.writeInt(elementTypeId);
        buf.writeUShort(enabledSkills.length);
        for (InteractiveElementSkill entry : enabledSkills) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(disabledSkills.length);
        for (InteractiveElementSkill entry : disabledSkills) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        elementId = buf.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
        elementTypeId = buf.readInt();
        int limit = buf.readUShort();
        enabledSkills = new InteractiveElementSkill[limit];
        for (int i = 0; i < limit; i++) {
            enabledSkills[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            enabledSkills[i].deserialize(buf);
        }
        limit = buf.readUShort();
        disabledSkills = new InteractiveElementSkill[limit];
        for (int i = 0; i < limit; i++) {
            disabledSkills[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            disabledSkills[i].deserialize(buf);
        }
    }
    
}
