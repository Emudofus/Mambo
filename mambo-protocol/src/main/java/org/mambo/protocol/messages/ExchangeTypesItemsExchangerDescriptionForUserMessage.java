

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeTypesItemsExchangerDescriptionForUserMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5752;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public BidExchangerObjectInfo[] itemTypeDescriptions;
    
    public ExchangeTypesItemsExchangerDescriptionForUserMessage() { }
    
    public ExchangeTypesItemsExchangerDescriptionForUserMessage(BidExchangerObjectInfo[] itemTypeDescriptions) {
        this.itemTypeDescriptions = itemTypeDescriptions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(itemTypeDescriptions.length);
        for (BidExchangerObjectInfo entry : itemTypeDescriptions) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        itemTypeDescriptions = new BidExchangerObjectInfo[limit];
        for (int i = 0; i < limit; i++) {
            itemTypeDescriptions[i] = new BidExchangerObjectInfo();
            itemTypeDescriptions[i].deserialize(buf);
        }
    }
    
}
