

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(level);
        guildInfo.serialize(writer);
        writer.writeInt(experienceForGuild);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        level = reader.readUnsignedByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(reader);
        experienceForGuild = reader.readInt();
    }
    
}
