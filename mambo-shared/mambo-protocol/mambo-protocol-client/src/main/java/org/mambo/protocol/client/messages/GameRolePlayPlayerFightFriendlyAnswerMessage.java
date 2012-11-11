

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayPlayerFightFriendlyAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5732;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public boolean accept;
    
    public GameRolePlayPlayerFightFriendlyAnswerMessage() { }
    
    public GameRolePlayPlayerFightFriendlyAnswerMessage(int fightId, boolean accept) {
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
