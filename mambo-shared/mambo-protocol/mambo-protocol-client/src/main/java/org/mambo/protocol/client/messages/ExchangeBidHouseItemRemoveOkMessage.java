

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeBidHouseItemRemoveOkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5946;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sellerId;
    
    public ExchangeBidHouseItemRemoveOkMessage() { }
    
    public ExchangeBidHouseItemRemoveOkMessage(int sellerId) {
        this.sellerId = sellerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(sellerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        sellerId = reader.readInt();
    }
    
}
