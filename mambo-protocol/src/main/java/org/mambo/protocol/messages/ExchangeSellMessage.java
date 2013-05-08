

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(objectToSellId);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectToSellId = buf.readInt();
        if (objectToSellId < 0)
            throw new RuntimeException("Forbidden value on objectToSellId = " + objectToSellId + ", it doesn't respect the following condition : objectToSellId < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
