

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(id);
        writer.writeBoolean(alive);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        id = reader.readInt();
        alive = reader.readBoolean();
    }
    
}
