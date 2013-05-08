

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SkillActionDescriptionCraft extends SkillActionDescription {
    public static final short TYPE_ID = 100;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte maxSlots;
    public byte probability;
    
    public SkillActionDescriptionCraft() { }
    
    public SkillActionDescriptionCraft(short skillId, byte maxSlots, byte probability) {
        super(skillId);
        this.maxSlots = maxSlots;
        this.probability = probability;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(maxSlots);
        buf.writeByte(probability);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        maxSlots = buf.readByte();
        if (maxSlots < 0)
            throw new RuntimeException("Forbidden value on maxSlots = " + maxSlots + ", it doesn't respect the following condition : maxSlots < 0");
        probability = buf.readByte();
        if (probability < 0)
            throw new RuntimeException("Forbidden value on probability = " + probability + ", it doesn't respect the following condition : probability < 0");
    }
    
}
