

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayArenaFightPropositionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6276;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public int[] alliesId;
    public short duration;
    
    public GameRolePlayArenaFightPropositionMessage() { }
    
    public GameRolePlayArenaFightPropositionMessage(int fightId, int[] alliesId, short duration) {
        this.fightId = fightId;
        this.alliesId = alliesId;
        this.duration = duration;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeUnsignedShort(alliesId.length);
        for (int entry : alliesId) {
            writer.writeInt(entry);
        }
        writer.writeShort(duration);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = reader.readUnsignedShort();
        alliesId = new int[limit];
        for (int i = 0; i < limit; i++) {
            alliesId[i] = reader.readInt();
        }
        duration = reader.readShort();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
    }
    
}
