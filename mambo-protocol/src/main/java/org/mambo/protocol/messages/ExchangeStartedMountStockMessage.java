

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objectsInfos.length);
        for (ObjectItem entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectsInfos = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItem();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
