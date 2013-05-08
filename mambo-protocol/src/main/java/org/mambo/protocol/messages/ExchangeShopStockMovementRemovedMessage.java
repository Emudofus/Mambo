

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeShopStockMovementRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5907;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectId;
    
    public ExchangeShopStockMovementRemovedMessage() { }
    
    public ExchangeShopStockMovementRemovedMessage(int objectId) {
        this.objectId = objectId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(objectId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectId = buf.readInt();
        if (objectId < 0)
            throw new RuntimeException("Forbidden value on objectId = " + objectId + ", it doesn't respect the following condition : objectId < 0");
    }
    
}
