

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ExchangeObjectMovePricedMessage extends ExchangeObjectMoveMessage {
    public static final int MESSAGE_ID = 5514;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int price;
    
    public ExchangeObjectMovePricedMessage() { }
    
    public ExchangeObjectMovePricedMessage(int objectUID, int quantity, int price) {
        super(objectUID, quantity);
        this.price = price;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        price = reader.readInt();
    }
    
}
