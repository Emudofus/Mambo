

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightResultMutantListEntry extends FightResultFighterListEntry {
    public static final short TYPE_ID = 216;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int level;
    
    public FightResultMutantListEntry() { }
    
    public FightResultMutantListEntry(short outcome, FightLoot rewards, int id, boolean alive, int level) {
        super(outcome, rewards, id, alive);
        this.level = level;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(level);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        level = buf.readUShort();
        if (level < 0 || level > 65535)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 65535");
    }
    
}
