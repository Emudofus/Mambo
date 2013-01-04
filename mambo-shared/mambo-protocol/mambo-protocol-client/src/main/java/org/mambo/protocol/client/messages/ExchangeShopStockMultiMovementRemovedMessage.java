

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
