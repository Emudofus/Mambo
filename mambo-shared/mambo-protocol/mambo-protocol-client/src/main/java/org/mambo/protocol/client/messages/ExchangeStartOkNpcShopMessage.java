

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkNpcShopMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5761;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int npcSellerId;
    public int tokenId;
    public ObjectItemToSellInNpcShop[] objectsInfos;
    
    public ExchangeStartOkNpcShopMessage() { }
    
    public ExchangeStartOkNpcShopMessage(int npcSellerId, int tokenId, ObjectItemToSellInNpcShop[] objectsInfos) {
        this.npcSellerId = npcSellerId;
        this.tokenId = tokenId;
        this.objectsInfos = objectsInfos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(npcSellerId);
        writer.writeInt(tokenId);
        writer.writeUnsignedShort(objectsInfos.length);
        for (ObjectItemToSellInNpcShop entry : objectsInfos) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        npcSellerId = reader.readInt();
        tokenId = reader.readInt();
        if (tokenId < 0)
            throw new RuntimeException("Forbidden value on tokenId = " + tokenId + ", it doesn't respect the following condition : tokenId < 0");
        int limit = reader.readUnsignedShort();
        objectsInfos = new ObjectItemToSellInNpcShop[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInNpcShop();
            objectsInfos[i].deserialize(reader);
        }
    }
    
}
