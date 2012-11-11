

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(houseId);
        writer.writeBoolean(bought);
        writer.writeInt(realPrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        bought = reader.readBoolean();
        realPrice = reader.readInt();
        if (realPrice < 0)
            throw new RuntimeException("Forbidden value on realPrice = " + realPrice + ", it doesn't respect the following condition : realPrice < 0");
    }
    
}
