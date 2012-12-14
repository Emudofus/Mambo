

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(uid);
        writer.writeInt(qty);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        qty = reader.readInt();
        if (qty < 0)
            throw new RuntimeException("Forbidden value on qty = " + qty + ", it doesn't respect the following condition : qty < 0");
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
