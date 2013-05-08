

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightResultTaxCollectorListEntry extends FightResultFighterListEntry {
    public static final short TYPE_ID = 84;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short level;
    public BasicGuildInformations guildInfo;
    public int experienceForGuild;
    
    public FightResultTaxCollectorListEntry() { }
    
    public FightResultTaxCollectorListEntry(short outcome, FightLoot rewards, int id, boolean alive, short level, BasicGuildInformations guildInfo, int experienceForGuild) {
        super(outcome, rewards, id, alive);
        this.level = level;
        this.guildInfo = guildInfo;
        this.experienceForGuild = experienceForGuild;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(level);
        guildInfo.serialize(buf);
        buf.writeInt(experienceForGuild);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        level = buf.readUByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(buf);
        experienceForGuild = buf.readInt();
    }
    
}
