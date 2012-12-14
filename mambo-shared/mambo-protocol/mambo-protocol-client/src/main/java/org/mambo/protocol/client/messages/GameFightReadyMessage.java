

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 708;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean isReady;
    
    public GameFightReadyMessage() { }
    
    public GameFightReadyMessage(boolean isReady) {
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
