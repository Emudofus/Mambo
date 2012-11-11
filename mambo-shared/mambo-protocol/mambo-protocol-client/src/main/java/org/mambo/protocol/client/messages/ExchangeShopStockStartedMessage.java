

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeShopStockStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5910;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemToSell[] objectsInfos;
    
    public ExchangeShopStockStartedMessage() { }
    
    public ExchangeShopStockStartedMessage(ObjectItemToSell[] objectsInfos) {
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItemToSell entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItemToSell[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSell();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
