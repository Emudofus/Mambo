

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightResultListEntry extends NetworkType {
    public static final short TYPE_ID = 16;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(outcome);
        rewards.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        outcome = buf.readShort();
        if (outcome < 0)
            throw new RuntimeException("Forbidden value on outcome = " + outcome + ", it doesn't respect the following condition : outcome < 0");
        rewards = new FightLoot();
        rewards.deserialize(buf);
    }
    
}
