

// Generated on 12/14/2012 18:44:13
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(genericId);
        writer.writeInt(averagePrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        genericId = reader.readInt();
        if (genericId < 0)
            throw new RuntimeException("Forbidden value on genericId = " + genericId + ", it doesn't respect the following condition : genericId < 0");
        averagePrice = reader.readInt();
        if (averagePrice < 0)
            throw new RuntimeException("Forbidden value on averagePrice = " + averagePrice + ", it doesn't respect the following condition : averagePrice < 0");
    }
    
}
