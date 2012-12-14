

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(maxSlots);
        writer.writeByte(probability);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        maxSlots = reader.readByte();
        if (maxSlots < 0)
            throw new RuntimeException("Forbidden value on maxSlots = " + maxSlots + ", it doesn't respect the following condition : maxSlots < 0");
        probability = reader.readByte();
        if (probability < 0)
            throw new RuntimeException("Forbidden value on probability = " + probability + ", it doesn't respect the following condition : probability < 0");
    }
    
}
