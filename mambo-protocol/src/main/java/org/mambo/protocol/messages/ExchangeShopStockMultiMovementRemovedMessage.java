

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objectIdList.length);
        for (int entry : objectIdList) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectIdList = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectIdList[i] = buf.readInt();
        }
    }
    
}
