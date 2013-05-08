

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightResultFighterListEntry extends FightResultListEntry {
    public static final short TYPE_ID = 189;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public boolean alive;
    
    public FightResultFighterListEntry() { }
    
    public FightResultFighterListEntry(short outcome, FightLoot rewards, int id, boolean alive) {
        super(outcome, rewards);
        this.id = id;
        this.alive = alive;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(id);
        buf.writeBoolean(alive);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        id = buf.readInt();
        alive = buf.readBoolean();
    }
    
}
