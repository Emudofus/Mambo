

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        itemInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        itemInfo = new ObjectItemToSellInBid();
        itemInfo.deserialize(reader);
    }
    
}
