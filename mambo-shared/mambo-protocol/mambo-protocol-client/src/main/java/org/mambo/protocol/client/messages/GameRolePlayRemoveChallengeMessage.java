

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
