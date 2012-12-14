

// Generated on 12/14/2012 18:44:15
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeShopStockMovementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5909;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell objectInfo;
    
    public ExchangeShopStockMovementUpdatedMessage() { }
    
    public ExchangeShopStockMovementUpdatedMessage(ObjectItemToSell objectInfo) {
        this.objectInfo = objectInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        objectInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectInfo = new ObjectItemToSell();
        objectInfo.deserialize(reader);
    }
    
}
