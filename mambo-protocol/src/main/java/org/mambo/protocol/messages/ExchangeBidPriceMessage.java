

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidPriceMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5755;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int genericId;
    public int averagePrice;
    
    public ExchangeBidPriceMessage() { }
    
    public ExchangeBidPriceMessage(int genericId, int averagePrice) {
        this.genericId = genericId;
        this.averagePrice = averagePrice;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(genericId);
        buf.writeInt(averagePrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        genericId = buf.readInt();
        if (genericId < 0)
            throw new RuntimeException("Forbidden value on genericId = " + genericId + ", it doesn't respect the following condition : genericId < 0");
        averagePrice = buf.readInt();
    }
    
}
