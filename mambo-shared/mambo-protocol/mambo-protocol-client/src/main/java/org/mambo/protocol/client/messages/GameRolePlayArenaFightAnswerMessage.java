

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayArenaFightAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6279;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public boolean accept;
    
    public GameRolePlayArenaFightAnswerMessage() { }
    
    public GameRolePlayArenaFightAnswerMessage(int fightId, boolean accept) {
        this.fightId = fightId;
        this.accept = accept;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeBoolean(accept);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        accept = reader.readBoolean();
    }
    
}
