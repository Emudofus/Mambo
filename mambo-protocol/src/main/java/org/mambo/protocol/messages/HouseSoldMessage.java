

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(houseId);
        buf.writeInt(realPrice);
        buf.writeString(buyerName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        realPrice = buf.readInt();
        if (realPrice < 0)
            throw new RuntimeException("Forbidden value on realPrice = " + realPrice + ", it doesn't respect the following condition : realPrice < 0");
        buyerName = buf.readString();
    }
    
}
