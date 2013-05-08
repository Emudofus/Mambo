

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartedBidSellerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5905;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public SellerBuyerDescriptor sellerDescriptor;
    public ObjectItemToSellInBid[] objectsInfos;
    
    public ExchangeStartedBidSellerMessage() { }
    
    public ExchangeStartedBidSellerMessage(SellerBuyerDescriptor sellerDescriptor, ObjectItemToSellInBid[] objectsInfos) {
        this.sellerDescriptor = sellerDescriptor;
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        sellerDescriptor.serialize(buf);
        buf.writeUShort(objectsInfos.length);
        for (ObjectItemToSellInBid entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        sellerDescriptor = new SellerBuyerDescriptor();
        sellerDescriptor.deserialize(buf);
        int limit = buf.readUShort();
        objectsInfos = new ObjectItemToSellInBid[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInBid();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
