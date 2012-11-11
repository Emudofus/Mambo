

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightTurnEndMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 719;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    
    public GameFightTurnEndMessage() { }
    
    public GameFightTurnEndMessage(int id) {
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
