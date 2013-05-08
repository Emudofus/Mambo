

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockToSellFilterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6161;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int areaId;
    public byte atLeastNbMount;
    public byte atLeastNbMachine;
    public int maxPrice;
    
    public PaddockToSellFilterMessage() { }
    
    public PaddockToSellFilterMessage(int areaId, byte atLeastNbMount, byte atLeastNbMachine, int maxPrice) {
        this.areaId = areaId;
        this.atLeastNbMount = atLeastNbMount;
        this.atLeastNbMachine = atLeastNbMachine;
        this.maxPrice = maxPrice;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(areaId);
        buf.writeByte(atLeastNbMount);
        buf.writeByte(atLeastNbMachine);
        buf.writeInt(maxPrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        areaId = buf.readInt();
        atLeastNbMount = buf.readByte();
        atLeastNbMachine = buf.readByte();
        maxPrice = buf.readInt();
        if (maxPrice < 0)
            throw new RuntimeException("Forbidden value on maxPrice = " + maxPrice + ", it doesn't respect the following condition : maxPrice < 0");
    }
    
}
