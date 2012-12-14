

// Generated on 12/14/2012 18:44:15
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartedBidBuyerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5904;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public SellerBuyerDescriptor buyerDescriptor;
    
    public ExchangeStartedBidBuyerMessage() { }
    
    public ExchangeStartedBidBuyerMessage(SellerBuyerDescriptor buyerDescriptor) {
        this.buyerDescriptor = buyerDescriptor;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        buyerDescriptor.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        buyerDescriptor = new SellerBuyerDescriptor();
        buyerDescriptor.deserialize(reader);
    }
    
}
