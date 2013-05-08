

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveElementWithAgeBonus extends InteractiveElement {
    public static final short TYPE_ID = 398;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short ageBonus;
    
    public InteractiveElementWithAgeBonus() { }
    
    public InteractiveElementWithAgeBonus(int elementId, int elementTypeId, InteractiveElementSkill[] enabledSkills, InteractiveElementSkill[] disabledSkills, short ageBonus) {
        super(elementId, elementTypeId, enabledSkills, disabledSkills);
        this.ageBonus = ageBonus;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(ageBonus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        ageBonus = buf.readShort();
        if (ageBonus < -1 || ageBonus > 1000)
            throw new RuntimeException("Forbidden value on ageBonus = " + ageBonus + ", it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000");
    }
    
}
