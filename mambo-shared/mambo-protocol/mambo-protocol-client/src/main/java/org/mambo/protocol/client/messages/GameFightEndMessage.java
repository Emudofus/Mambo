

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightEndMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 720;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int duration;
    public short ageBonus;
    public FightResultListEntry[] results;
    
    public GameFightEndMessage() { }
    
    public GameFightEndMessage(int duration, short ageBonus, FightResultListEntry[] results) {
        this.duration = duration;
        this.ageBonus = ageBonus;
        this.results = results;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(duration);
        writer.writeShort(ageBonus);
        writer.writeUnsignedShort(results.length);
        for (FightResultListEntry entry : results) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        duration = reader.readInt();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
        ageBonus = reader.readShort();
        int limit = reader.readUnsignedShort();
        results = new FightResultListEntry[limit];
        for (int i = 0; i < limit; i++) {
            results[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), FightResultListEntry.class);
            results[i].deserialize(reader);
        }
    }
    
}
