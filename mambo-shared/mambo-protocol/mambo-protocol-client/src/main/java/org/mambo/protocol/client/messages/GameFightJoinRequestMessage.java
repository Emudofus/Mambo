

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightJoinRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 701;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fighterId;
    public int fightId;
    
    public GameFightJoinRequestMessage() { }
    
    public GameFightJoinRequestMessage(int fighterId, int fightId) {
        this.fighterId = fighterId;
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fighterId);
        writer.writeInt(fightId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fighterId = reader.readInt();
        fightId = reader.readInt();
    }
    
}
