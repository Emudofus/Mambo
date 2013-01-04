

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(ageBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        ageBonus = reader.readShort();
        if (ageBonus < -1 || ageBonus > 1000)
            throw new RuntimeException("Forbidden value on ageBonus = " + ageBonus + ", it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000");
    }
    
}
