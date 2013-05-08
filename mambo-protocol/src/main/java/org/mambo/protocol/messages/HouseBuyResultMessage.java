

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseBuyResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5735;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    public boolean bought;
    public int realPrice;
    
    public HouseBuyResultMessage() { }
    
    public HouseBuyResultMessage(int houseId, boolean bought, int realPrice) {
        this.houseId = houseId;
        this.bought = bought;
        this.realPrice = realPrice;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(houseId);
        buf.writeBoolean(bought);
        buf.writeInt(realPrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        bought = buf.readBoolean();
        realPrice = buf.readInt();
        if (realPrice < 0)
            throw new RuntimeException("Forbidden value on realPrice = " + realPrice + ", it doesn't respect the following condition : realPrice < 0");
    }
    
}
