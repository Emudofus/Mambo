

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUByte(level);
        buf.writeUShort(additional.length);
        for (FightResultAdditionalData entry : additional) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        level = buf.readUByte();
        if (level < 1 || level > 200)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 1 || level > 200");
        int limit = buf.readUShort();
        additional = new FightResultAdditionalData[limit];
        for (int i = 0; i < limit; i++) {
            additional[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            additional[i].deserialize(buf);
        }
    }
    
}
