

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class SkillActionDescriptionCraftExtended extends SkillActionDescriptionCraft {
    public static final short TYPE_ID = 104;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte thresholdSlots;
    public byte optimumProbability;
    
    public SkillActionDescriptionCraftExtended() { }
    
    public SkillActionDescriptionCraftExtended(short skillId, byte maxSlots, byte probability, byte thresholdSlots, byte optimumProbability) {
        super(skillId, maxSlots, probability);
        this.thresholdSlots = thresholdSlots;
        this.optimumProbability = optimumProbability;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(thresholdSlots);
        writer.writeByte(optimumProbability);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        thresholdSlots = reader.readByte();
        if (thresholdSlots < 0)
            throw new RuntimeException("Forbidden value on thresholdSlots = " + thresholdSlots + ", it doesn't respect the following condition : thresholdSlots < 0");
        optimumProbability = reader.readByte();
        if (optimumProbability < 0)
            throw new RuntimeException("Forbidden value on optimumProbability = " + optimumProbability + ", it doesn't respect the following condition : optimumProbability < 0");
    }
    
}
