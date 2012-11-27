

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(bsell);
        writer.writeInt(ownerId);
        writer.writeInt(price);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        bsell = reader.readBoolean();
        ownerId = reader.readInt();
        if (ownerId < 0)
            throw new RuntimeException("Forbidden value on ownerId = " + ownerId + ", it doesn't respect the following condition : ownerId < 0");
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
    }
    
}
