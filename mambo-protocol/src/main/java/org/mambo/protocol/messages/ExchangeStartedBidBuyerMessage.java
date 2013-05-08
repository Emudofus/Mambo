

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buyerDescriptor.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        buyerDescriptor = new SellerBuyerDescriptor();
        buyerDescriptor.deserialize(buf);
    }
    
}
