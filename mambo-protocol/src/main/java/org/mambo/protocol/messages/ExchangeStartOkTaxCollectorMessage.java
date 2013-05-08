

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartOkTaxCollectorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5780;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int collectorId;
    public ObjectItem[] objectsInfos;
    public int goldInfo;
    
    public ExchangeStartOkTaxCollectorMessage() { }
    
    public ExchangeStartOkTaxCollectorMessage(int collectorId, ObjectItem[] objectsInfos, int goldInfo) {
        this.collectorId = collectorId;
        this.objectsInfos = objectsInfos;
        this.goldInfo = goldInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(collectorId);
        buf.writeUShort(objectsInfos.length);
        for (ObjectItem entry : objectsInfos) {
            entry.serialize(buf);
        }
        buf.writeInt(goldInfo);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        collectorId = buf.readInt();
        int limit = buf.readUShort();
        objectsInfos = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItem();
            objectsInfos[i].deserialize(buf);
        }
        goldInfo = buf.readInt();
        if (goldInfo < 0)
            throw new RuntimeException("Forbidden value on goldInfo = " + goldInfo + ", it doesn't respect the following condition : goldInfo < 0");
    }
    
}
