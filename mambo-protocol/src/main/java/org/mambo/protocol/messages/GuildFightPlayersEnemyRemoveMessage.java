

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildFightPlayersEnemyRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5929;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int playerId;
    
    public GuildFightPlayersEnemyRemoveMessage() { }
    
    public GuildFightPlayersEnemyRemoveMessage(double fightId, int playerId) {
        this.fightId = fightId;
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
