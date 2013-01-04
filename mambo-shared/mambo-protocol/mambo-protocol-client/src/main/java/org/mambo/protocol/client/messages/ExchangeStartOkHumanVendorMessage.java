

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkHumanVendorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5767;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sellerId;
    public ObjectItemToSellInHumanVendorShop[] objectsInfos;
    
    public ExchangeStartOkHumanVendorMessage() { }
    
    public ExchangeStartOkHumanVendorMessage(int sellerId, ObjectItemToSellInHumanVendorShop[] objectsInfos) {
        this.sellerId = sellerId;
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(sellerId);
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItemToSellInHumanVendorShop entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        sellerId = reader.readInt();
        if (sellerId < 0)
            throw new RuntimeException("Forbidden value on sellerId = " + sellerId + ", it doesn't respect the following condition : sellerId < 0");
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItemToSellInHumanVendorShop[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInHumanVendorShop();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
