

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightEndMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 720;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int duration;
    public short ageBonus;
    public short lootShareLimitMalus;
    public FightResultListEntry[] results;
    
    public GameFightEndMessage() { }
    
    public GameFightEndMessage(int duration, short ageBonus, short lootShareLimitMalus, FightResultListEntry[] results) {
        this.duration = duration;
        this.ageBonus = ageBonus;
        this.lootShareLimitMalus = lootShareLimitMalus;
        this.results = results;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(duration);
        buf.writeShort(ageBonus);
        buf.writeShort(lootShareLimitMalus);
        buf.writeUShort(results.length);
        for (FightResultListEntry entry : results) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        duration = buf.readInt();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
        ageBonus = buf.readShort();
        lootShareLimitMalus = buf.readShort();
        int limit = buf.readUShort();
        results = new FightResultListEntry[limit];
        for (int i = 0; i < limit; i++) {
            results[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            results[i].deserialize(buf);
        }
    }
    
}
