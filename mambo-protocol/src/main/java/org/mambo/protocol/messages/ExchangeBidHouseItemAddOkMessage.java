

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseItemAddOkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5945;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSellInBid itemInfo;
    
    public ExchangeBidHouseItemAddOkMessage() { }
    
    public ExchangeBidHouseItemAddOkMessage(ObjectItemToSellInBid itemInfo) {
        this.itemInfo = itemInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        itemInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        itemInfo = new ObjectItemToSellInBid();
        itemInfo.deserialize(buf);
    }
    
}
