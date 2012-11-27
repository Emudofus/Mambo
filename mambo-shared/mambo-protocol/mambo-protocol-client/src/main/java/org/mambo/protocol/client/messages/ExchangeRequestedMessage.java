

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeRequestedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5522;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte exchangeType;
    
    public ExchangeRequestedMessage() { }
    
    public ExchangeRequestedMessage(byte exchangeType) {
        this.exchangeType = exchangeType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(exchangeType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        exchangeType = reader.readByte();
    }
    
}
