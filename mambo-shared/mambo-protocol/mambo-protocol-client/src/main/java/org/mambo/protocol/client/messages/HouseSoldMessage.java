

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class HouseSoldMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5737;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    public int realPrice;
    public String buyerName;
    
    public HouseSoldMessage() { }
    
    public HouseSoldMessage(int houseId, int realPrice, String buyerName) {
        this.houseId = houseId;
        this.realPrice = realPrice;
        this.buyerName = buyerName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(houseId);
        writer.writeInt(realPrice);
        writer.writeString(buyerName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        realPrice = reader.readInt();
        if (realPrice < 0)
            throw new RuntimeException("Forbidden value on realPrice = " + realPrice + ", it doesn't respect the following condition : realPrice < 0");
        buyerName = reader.readString();
    }
    
}
