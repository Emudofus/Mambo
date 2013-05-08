

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeShopStockMovementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5909;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell objectInfo;
    
    public ExchangeShopStockMovementUpdatedMessage() { }
    
    public ExchangeShopStockMovementUpdatedMessage(ObjectItemToSell objectInfo) {
        this.objectInfo = objectInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        objectInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectInfo = new ObjectItemToSell();
        objectInfo.deserialize(buf);
    }
    
}
