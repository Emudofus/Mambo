

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, showExperience);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, showExperienceLevelFloor);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, showExperienceNextLevelFloor);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, showExperienceFightDelta);
        flag1 = BooleanByteWrapper.setFlag(flag1, 4, showExperienceForGuild);
        flag1 = BooleanByteWrapper.setFlag(flag1, 5, showExperienceForMount);
        flag1 = BooleanByteWrapper.setFlag(flag1, 6, isIncarnationExperience);
        buf.writeUByte(flag1);
        buf.writeDouble(experience);
        buf.writeDouble(experienceLevelFloor);
        buf.writeDouble(experienceNextLevelFloor);
        buf.writeInt(experienceFightDelta);
        buf.writeInt(experienceForGuild);
        buf.writeInt(experienceForMount);
        buf.writeInt(rerollExperienceMul);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        short flag1 = buf.readUByte();
        showExperience = BooleanByteWrapper.getFlag(flag1, 0);
        showExperienceLevelFloor = BooleanByteWrapper.getFlag(flag1, 1);
        showExperienceNextLevelFloor = BooleanByteWrapper.getFlag(flag1, 2);
        showExperienceFightDelta = BooleanByteWrapper.getFlag(flag1, 3);
        showExperienceForGuild = BooleanByteWrapper.getFlag(flag1, 4);
        showExperienceForMount = BooleanByteWrapper.getFlag(flag1, 5);
        isIncarnationExperience = BooleanByteWrapper.getFlag(flag1, 6);
        experience = buf.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        experienceLevelFloor = buf.readDouble();
        if (experienceLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceLevelFloor = " + experienceLevelFloor + ", it doesn't respect the following condition : experienceLevelFloor < 0");
        experienceNextLevelFloor = buf.readDouble();
        if (experienceNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceNextLevelFloor = " + experienceNextLevelFloor + ", it doesn't respect the following condition : experienceNextLevelFloor < 0");
        experienceFightDelta = buf.readInt();
        experienceForGuild = buf.readInt();
        if (experienceForGuild < 0)
            throw new RuntimeException("Forbidden value on experienceForGuild = " + experienceForGuild + ", it doesn't respect the following condition : experienceForGuild < 0");
        experienceForMount = buf.readInt();
        if (experienceForMount < 0)
            throw new RuntimeException("Forbidden value on experienceForMount = " + experienceForMount + ", it doesn't respect the following condition : experienceForMount < 0");
        rerollExperienceMul = buf.readInt();
    }
    
}
