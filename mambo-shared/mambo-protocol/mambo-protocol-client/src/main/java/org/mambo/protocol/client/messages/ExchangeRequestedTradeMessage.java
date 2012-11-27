

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ExchangeRequestedTradeMessage extends ExchangeRequestedMessage {
    public static final int MESSAGE_ID = 5523;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int source;
    public int target;
    
    public ExchangeRequestedTradeMessage() { }
    
    public ExchangeRequestedTradeMessage(byte exchangeType, int source, int target) {
        super(exchangeType);
        this.source = source;
        this.target = target;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(source);
        writer.writeInt(target);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        source = reader.readInt();
        if (source < 0)
            throw new RuntimeException("Forbidden value on source = " + source + ", it doesn't respect the following condition : source < 0");
        target = reader.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
    }
    
}
