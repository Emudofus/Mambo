

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightResultExperienceData extends FightResultAdditionalData {
    public static final short TYPE_ID = 192;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean showExperience;
    public boolean showExperienceLevelFloor;
    public boolean showExperienceNextLevelFloor;
    public boolean showExperienceFightDelta;
    public boolean showExperienceForGuild;
    public boolean showExperienceForMount;
    public boolean isIncarnationExperience;
    public double experience;
    public double experienceLevelFloor;
    public double experienceNextLevelFloor;
    public int experienceFightDelta;
    public int experienceForGuild;
    public int experienceForMount;
    public int rerollExperienceMul;
    
    public FightResultExperienceData() { }
    
    public FightResultExperienceData(boolean showExperience, boolean showExperienceLevelFloor, boolean showExperienceNextLevelFloor, boolean showExperienceFightDelta, boolean showExperienceForGuild, boolean showExperienceForMount, boolean isIncarnationExperience, double experience, double experienceLevelFloor, double experienceNextLevelFloor, int experienceFightDelta, int experienceForGuild, int experienceForMount, int rerollExperienceMul) {
        this.showExperience = showExperience;
        this.showExperienceLevelFloor = showExperienceLevelFloor;
        this.showExperienceNextLevelFloor = showExperienceNextLevelFloor;
        this.showExperienceFightDelta = showExperienceFightDelta;
        this.showExperienceForGuild = showExperienceForGuild;
        this.showExperienceForMount = showExperienceForMount;
        this.isIncarnationExperience = isIncarnationExperience;
        this.experience = experience;
        this.experienceLevelFloor = experienceLevelFloor;
        this.experienceNextLevelFloor = experienceNextLevelFloor;
        this.experienceFightDelta = experienceFightDelta;
        this.experienceForGuild = experienceForGuild;
        this.experienceForMount = experienceForMount;
        this.rerollExperienceMul = rerollExperienceMul;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, showExperience);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, showExperienceLevelFloor);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, showExperienceNextLevelFloor);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, showExperienceFightDelta);
        flag1 = BooleanByteWrapper.setFlag(flag1, 4, showExperienceForGuild);
        flag1 = BooleanByteWrapper.setFlag(flag1, 5, showExperienceForMount);
        flag1 = BooleanByteWrapper.setFlag(flag1, 6, isIncarnationExperience);
        writer.writeUnsignedByte(flag1);
        writer.writeDouble(experience);
        writer.writeDouble(experienceLevelFloor);
        writer.writeDouble(experienceNextLevelFloor);
        writer.writeInt(experienceFightDelta);
        writer.writeInt(experienceForGuild);
        writer.writeInt(experienceForMount);
        writer.writeInt(rerollExperienceMul);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        short flag1 = reader.readUnsignedByte();
        showExperience = BooleanByteWrapper.getFlag(flag1, 0);
        showExperienceLevelFloor = BooleanByteWrapper.getFlag(flag1, 1);
        showExperienceNextLevelFloor = BooleanByteWrapper.getFlag(flag1, 2);
        showExperienceFightDelta = BooleanByteWrapper.getFlag(flag1, 3);
        showExperienceForGuild = BooleanByteWrapper.getFlag(flag1, 4);
        showExperienceForMount = BooleanByteWrapper.getFlag(flag1, 5);
        isIncarnationExperience = BooleanByteWrapper.getFlag(flag1, 6);
        experience = reader.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        experienceLevelFloor = reader.readDouble();
        if (experienceLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceLevelFloor = " + experienceLevelFloor + ", it doesn't respect the following condition : experienceLevelFloor < 0");
        experienceNextLevelFloor = reader.readDouble();
        if (experienceNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceNextLevelFloor = " + experienceNextLevelFloor + ", it doesn't respect the following condition : experienceNextLevelFloor < 0");
        experienceFightDelta = reader.readInt();
        experienceForGuild = reader.readInt();
        if (experienceForGuild < 0)
            throw new RuntimeException("Forbidden value on experienceForGuild = " + experienceForGuild + ", it doesn't respect the following condition : experienceForGuild < 0");
        experienceForMount = reader.readInt();
        if (experienceForMount < 0)
            throw new RuntimeException("Forbidden value on experienceForMount = " + experienceForMount + ", it doesn't respect the following condition : experienceForMount < 0");
        rerollExperienceMul = reader.readInt();
    }
    
}
