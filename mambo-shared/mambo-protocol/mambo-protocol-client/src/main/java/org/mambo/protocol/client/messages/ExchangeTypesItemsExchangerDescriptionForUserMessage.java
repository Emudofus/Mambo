

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(itemTypeDescriptions.length);
        for (BidExchangerObjectInfo entry : itemTypeDescriptions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        itemTypeDescriptions = new BidExchangerObjectInfo[limit];
        for (int i = 0; i < limit; i++) {
            itemTypeDescriptions[i] = new BidExchangerObjectInfo();
            itemTypeDescriptions[i].deserialize(reader);
        }
    }
    
}
