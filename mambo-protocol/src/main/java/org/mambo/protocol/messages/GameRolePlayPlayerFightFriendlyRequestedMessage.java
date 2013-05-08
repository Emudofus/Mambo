

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayPlayerFightFriendlyRequestedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5937;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public int sourceId;
    public int targetId;
    
    public GameRolePlayPlayerFightFriendlyRequestedMessage() { }
    
    public GameRolePlayPlayerFightFriendlyRequestedMessage(int fightId, int sourceId, int targetId) {
        this.fightId = fightId;
        this.sourceId = sourceId;
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeInt(sourceId);
        buf.writeInt(targetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        sourceId = buf.readInt();
        if (sourceId < 0)
            throw new RuntimeException("Forbidden value on sourceId = " + sourceId + ", it doesn't respect the following condition : sourceId < 0");
        targetId = buf.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
    }
    
}
