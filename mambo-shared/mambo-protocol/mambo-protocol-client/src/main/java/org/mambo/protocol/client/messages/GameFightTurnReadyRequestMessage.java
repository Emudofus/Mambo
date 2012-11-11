

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightTurnReadyRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 715;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    
    public GameFightTurnReadyRequestMessage() { }
    
    public GameFightTurnReadyRequestMessage(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
    }
    
}
