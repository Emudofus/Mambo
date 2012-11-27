

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5511;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean ready;
    public short step;
    
    public ExchangeReadyMessage() { }
    
    public ExchangeReadyMessage(boolean ready, short step) {
        this.ready = ready;
        this.step = step;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(ready);
        writer.writeShort(step);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        ready = reader.readBoolean();
        step = reader.readShort();
        if (step < 0)
            throw new RuntimeException("Forbidden value on step = " + step + ", it doesn't respect the following condition : step < 0");
    }
    
}
