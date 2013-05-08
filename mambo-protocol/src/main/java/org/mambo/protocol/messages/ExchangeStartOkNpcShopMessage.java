

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(npcSellerId);
        buf.writeInt(tokenId);
        buf.writeUShort(objectsInfos.length);
        for (ObjectItemToSellInNpcShop entry : objectsInfos) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        npcSellerId = buf.readInt();
        tokenId = buf.readInt();
        if (tokenId < 0)
            throw new RuntimeException("Forbidden value on tokenId = " + tokenId + ", it doesn't respect the following condition : tokenId < 0");
        int limit = buf.readUShort();
        objectsInfos = new ObjectItemToSellInNpcShop[limit];
        for (int i = 0; i < limit; i++) {
            objectsInfos[i] = new ObjectItemToSellInNpcShop();
            objectsInfos[i].deserialize(buf);
        }
    }
    
}
