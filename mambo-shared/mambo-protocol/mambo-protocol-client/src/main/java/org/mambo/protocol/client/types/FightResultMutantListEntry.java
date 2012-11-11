

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(level);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        level = reader.readUnsignedShort();
        if (level < 0 || level > 65535)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 65535");
    }
    
}
