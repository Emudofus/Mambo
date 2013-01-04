

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeInt(playerId);
        writer.writeBoolean(accepted);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        accepted = reader.readBoolean();
    }
    
}
