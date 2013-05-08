

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBuyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5774;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectToBuyId;
    public int quantity;
    
    public ExchangeBuyMessage() { }
    
    public ExchangeBuyMessage(int objectToBuyId, int quantity) {
        this.objectToBuyId = objectToBuyId;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(objectToBuyId);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectToBuyId = buf.readInt();
        if (objectToBuyId < 0)
            throw new RuntimeException("Forbidden value on objectToBuyId = " + objectToBuyId + ", it doesn't respect the following condition : objectToBuyId < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
