

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartOkHumanVendorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5767;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sellerId;
    public ObjectItemToSellInHumanVendorShop[] objectsInfos;
    
    public ExchangeStartOkHumanVendorMessage() { }
    
    public ExchangeStartOkHumanVendorMessage(int sellerId, ObjectItemToSellInHumanVendorShop[] objectsInfos) {
        this.sellerId = sellerId;
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(sellerId);
        buf.writeUShort(objectsInfos.length);
        for (ObjectItemToSellInHumanVendorShop entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        sellerId = buf.readInt();
        if (sellerId < 0)
            throw new RuntimeException("Forbidden value on sellerId = " + sellerId + ", it doesn't respect the following condition : sellerId < 0");
        int limit = buf.readUShort();
        objectsInfos = new ObjectItemToSellInHumanVendorShop[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInHumanVendorShop();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
