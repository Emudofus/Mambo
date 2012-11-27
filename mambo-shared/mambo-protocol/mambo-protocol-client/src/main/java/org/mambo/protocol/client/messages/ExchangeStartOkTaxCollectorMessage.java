

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(collectorId);
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItem entry : objectsInfos) {
            entry.serialize(writer);
        }
        writer.writeInt(goldInfo);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        collectorId = reader.readInt();
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItem();
            objectsInfos[i].deserialize(reader);
        }
        goldInfo = reader.readInt();
        if (goldInfo < 0)
            throw new RuntimeException("Forbidden value on goldInfo = " + goldInfo + ", it doesn't respect the following condition : goldInfo < 0");
    }
    
}
