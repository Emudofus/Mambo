

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeShopStockMultiMovementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6038;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell[] objectInfoList;
    
    public ExchangeShopStockMultiMovementUpdatedMessage() { }
    
    public ExchangeShopStockMultiMovementUpdatedMessage(ObjectItemToSell[] objectInfoList) {
        this.objectInfoList = objectInfoList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectInfoList.length);
        for (ObjectItemToSell entry : objectInfoList) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectInfoList = new ObjectItemToSell[limit];
        for (int i = 0; i < limit; i++) {
            objectInfoList[i] = new ObjectItemToSell();
            objectInfoList[i].deserialize(reader);
        }
    }
    
}
