

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        sellerDescriptor.serialize(writer);
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItemToSellInBid entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        sellerDescriptor = new SellerBuyerDescriptor();
        sellerDescriptor.deserialize(reader);
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItemToSellInBid[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInBid();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
