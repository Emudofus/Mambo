

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartedMountStockMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5984;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objectsInfos;
    
    public ExchangeStartedMountStockMessage() { }
    
    public ExchangeStartedMountStockMessage(ObjectItem[] objectsInfos) {
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItem entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItem();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
