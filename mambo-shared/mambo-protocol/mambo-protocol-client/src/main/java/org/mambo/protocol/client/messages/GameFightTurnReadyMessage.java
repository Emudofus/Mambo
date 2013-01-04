

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightTurnReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 716;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean isReady;
    
    public GameFightTurnReadyMessage() { }
    
    public GameFightTurnReadyMessage(boolean isReady) {
        this.isReady = isReady;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(isReady);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        isReady = reader.readBoolean();
    }
    
}
