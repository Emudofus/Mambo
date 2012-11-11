

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeShopStockMultiMovementRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6037;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] objectIdList;
    
    public ExchangeShopStockMultiMovementRemovedMessage() { }
    
    public ExchangeShopStockMultiMovementRemovedMessage(int[] objectIdList) {
        this.objectIdList = objectIdList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectIdList.length);
        for (int entry : objectIdList) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectIdList = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectIdList[i] = reader.readInt();
        }
    }
    
}
