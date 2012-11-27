

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ExchangePlayerRequestMessage extends ExchangeRequestMessage {
    public static final int MESSAGE_ID = 5773;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int target;
    
    public ExchangePlayerRequestMessage() { }
    
    public ExchangePlayerRequestMessage(byte exchangeType, int target) {
        super(exchangeType);
        this.target = target;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(target);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        target = reader.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
    }
    
}
