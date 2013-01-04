

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeSellMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5778;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectToSellId;
    public int quantity;
    
    public ExchangeSellMessage() { }
    
    public ExchangeSellMessage(int objectToSellId, int quantity) {
        this.objectToSellId = objectToSellId;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectToSellId);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectToSellId = reader.readInt();
        if (objectToSellId < 0)
            throw new RuntimeException("Forbidden value on objectToSellId = " + objectToSellId + ", it doesn't respect the following condition : objectToSellId < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
