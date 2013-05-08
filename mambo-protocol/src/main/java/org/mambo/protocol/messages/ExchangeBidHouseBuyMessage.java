

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseBuyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5804;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int uid;
    public int qty;
    public int price;
    
    public ExchangeBidHouseBuyMessage() { }
    
    public ExchangeBidHouseBuyMessage(int uid, int qty, int price) {
        this.uid = uid;
        this.qty = qty;
        this.price = price;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(uid);
        buf.writeInt(qty);
        buf.writeInt(price);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        qty = buf.readInt();
        if (qty < 0)
            throw new RuntimeException("Forbidden value on qty = " + qty + ", it doesn't respect the following condition : qty < 0");
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
