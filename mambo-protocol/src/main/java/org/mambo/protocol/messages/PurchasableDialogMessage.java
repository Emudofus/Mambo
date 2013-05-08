

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(buyOrSell);
        buf.writeInt(purchasableId);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        buyOrSell = buf.readBoolean();
        purchasableId = buf.readInt();
        if (purchasableId < 0)
            throw new RuntimeException("Forbidden value on purchasableId = " + purchasableId + ", it doesn't respect the following condition : purchasableId < 0");
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
