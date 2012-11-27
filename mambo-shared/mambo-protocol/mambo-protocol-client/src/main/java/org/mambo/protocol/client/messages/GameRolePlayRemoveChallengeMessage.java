

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayRemoveChallengeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 300;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    
    public GameRolePlayRemoveChallengeMessage() { }
    
    public GameRolePlayRemoveChallengeMessage(int fightId) {
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
    }
    
}
