

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
