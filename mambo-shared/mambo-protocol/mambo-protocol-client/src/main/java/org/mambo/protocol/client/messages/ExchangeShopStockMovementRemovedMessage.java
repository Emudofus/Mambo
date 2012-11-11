

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeShopStockMovementRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5907;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectId;
    
    public ExchangeShopStockMovementRemovedMessage() { }
    
    public ExchangeShopStockMovementRemovedMessage(int objectId) {
        this.objectId = objectId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectId = reader.readInt();
        if (objectId < 0)
            throw new RuntimeException("Forbidden value on objectId = " + objectId + ", it doesn't respect the following condition : objectId < 0");
    }
    
}
