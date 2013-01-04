

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightResultListEntry implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 16;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short outcome;
    public FightLoot rewards;
    
    public FightResultListEntry() { }
    
    public FightResultListEntry(short outcome, FightLoot rewards) {
        this.outcome = outcome;
        this.rewards = rewards;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(outcome);
        rewards.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        outcome = reader.readShort();
        if (outcome < 0)
            throw new RuntimeException("Forbidden value on outcome = " + outcome + ", it doesn't respect the following condition : outcome < 0");
        rewards = new FightLoot();
        rewards.deserialize(reader);
    }
    
}
