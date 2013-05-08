

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeShopStockMultiMovementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6038;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell[] objectInfoList;
    
    public ExchangeShopStockMultiMovementUpdatedMessage() { }
    
    public ExchangeShopStockMultiMovementUpdatedMessage(ObjectItemToSell[] objectInfoList) {
        this.objectInfoList = objectInfoList;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(objectInfoList.length);
        for (ObjectItemToSell entry : objectInfoList) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectInfoList = new ObjectItemToSell[limit];
        for (int i = 0; i < limit; i++) {
            objectInfoList[i] = new ObjectItemToSell();
            objectInfoList[i].deserialize(buf);
        }
    }
    
}
