

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeIsReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5509;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    public boolean ready;
    
    public ExchangeIsReadyMessage() { }
    
    public ExchangeIsReadyMessage(int id, boolean ready) {
        this.id = id;
        this.ready = ready;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeBoolean(ready);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        ready = reader.readBoolean();
    }
    
}
