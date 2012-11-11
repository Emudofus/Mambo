

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightResultPlayerListEntry extends FightResultFighterListEntry {
    public static final short TYPE_ID = 24;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short level;
    public FightResultAdditionalData[] additional;
    
    public FightResultPlayerListEntry() { }
    
    public FightResultPlayerListEntry(short outcome, FightLoot rewards, int id, boolean alive, short level, FightResultAdditionalData[] additional) {
        super(outcome, rewards, id, alive);
        this.level = level;
        this.additional = additional;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(level);
        writer.writeUnsignedShort(additional.length);
        for (FightResultAdditionalData entry : additional) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        level = reader.readUnsignedByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        int limit = reader.readUnsignedShort();
        additional = new FightResultAdditionalData[limit];
        for (int i = 0; i < limit; i++) {
            additional[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), FightResultAdditionalData.class);
            additional[i].deserialize(reader);
        }
    }
    
}
