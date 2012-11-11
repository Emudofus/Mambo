

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5511;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean ready;
    
    public ExchangeReadyMessage() { }
    
    public ExchangeReadyMessage(boolean ready) {
        this.ready = ready;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(ready);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        ready = reader.readBoolean();
    }
    
}
