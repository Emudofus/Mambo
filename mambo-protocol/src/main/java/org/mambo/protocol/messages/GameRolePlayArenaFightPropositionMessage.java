

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeUShort(alliesId.length);
        for (int entry : alliesId) {
            buf.writeInt(entry);
        }
        buf.writeShort(duration);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = buf.readUShort();
        alliesId = new int[limit];
        for (int i = 0; i < limit; i++) {
            alliesId[i] = buf.readInt();
        }
        duration = buf.readShort();
        if (duration < 0)
            throw new RuntimeException("Forbidden value on duration = " + duration + ", it doesn't respect the following condition : duration < 0");
    }
    
}
