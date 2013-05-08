

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayArenaFighterStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6281;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public int playerId;
    public boolean accepted;
    
    public GameRolePlayArenaFighterStatusMessage() { }
    
    public GameRolePlayArenaFighterStatusMessage(int fightId, int playerId, boolean accepted) {
        this.fightId = fightId;
        this.playerId = playerId;
        this.accepted = accepted;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeInt(playerId);
        buf.writeBoolean(accepted);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        accepted = buf.readBoolean();
    }
    
}
