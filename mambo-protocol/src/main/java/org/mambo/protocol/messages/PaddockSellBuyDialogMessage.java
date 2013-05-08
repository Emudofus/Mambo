

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockSellBuyDialogMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6018;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean bsell;
    public int ownerId;
    public int price;
    
    public PaddockSellBuyDialogMessage() { }
    
    public PaddockSellBuyDialogMessage(boolean bsell, int ownerId, int price) {
        this.bsell = bsell;
        this.ownerId = ownerId;
        this.price = price;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(bsell);
        buf.writeInt(ownerId);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        bsell = buf.readBoolean();
        ownerId = buf.readInt();
        if (ownerId < 0)
            throw new RuntimeException("Forbidden value on ownerId = " + ownerId + ", it doesn't respect the following condition : ownerId < 0");
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
