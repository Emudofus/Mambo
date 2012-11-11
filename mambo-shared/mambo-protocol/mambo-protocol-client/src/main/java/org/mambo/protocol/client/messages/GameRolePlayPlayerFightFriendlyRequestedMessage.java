

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeInt(sourceId);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        sourceId = reader.readInt();
        if (sourceId < 0)
            throw new RuntimeException("Forbidden value on sourceId = " + sourceId + ", it doesn't respect the following condition : sourceId < 0");
        targetId = reader.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
    }
    
}
