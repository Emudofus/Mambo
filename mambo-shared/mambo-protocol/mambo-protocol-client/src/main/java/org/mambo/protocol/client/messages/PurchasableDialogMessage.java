

// Generated on 12/14/2012 18:44:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PurchasableDialogMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5739;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean buyOrSell;
    public int purchasableId;
    public int price;
    
    public PurchasableDialogMessage() { }
    
    public PurchasableDialogMessage(boolean buyOrSell, int purchasableId, int price) {
        this.buyOrSell = buyOrSell;
        this.purchasableId = purchasableId;
        this.price = price;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(buyOrSell);
        writer.writeInt(purchasableId);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        buyOrSell = reader.readBoolean();
        purchasableId = reader.readInt();
        if (purchasableId < 0)
            throw new RuntimeException("Forbidden value on purchasableId = " + purchasableId + ", it doesn't respect the following condition : purchasableId < 0");
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
