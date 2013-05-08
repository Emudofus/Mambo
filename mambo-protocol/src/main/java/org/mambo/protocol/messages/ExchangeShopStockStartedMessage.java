

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeShopStockStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5910;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell[] objectsInfos;
    
    public ExchangeShopStockStartedMessage() { }
    
    public ExchangeShopStockStartedMessage(ObjectItemToSell[] objectsInfos) {
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(objectsInfos.length);
        for (ObjectItemToSell entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectsInfos = new ObjectItemToSell[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSell();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
