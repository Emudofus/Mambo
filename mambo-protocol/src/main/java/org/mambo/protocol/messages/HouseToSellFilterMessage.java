

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseToSellFilterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6137;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int areaId;
    public byte atLeastNbRoom;
    public byte atLeastNbChest;
    public short skillRequested;
    public int maxPrice;
    
    public HouseToSellFilterMessage() { }
    
    public HouseToSellFilterMessage(int areaId, byte atLeastNbRoom, byte atLeastNbChest, short skillRequested, int maxPrice) {
        this.areaId = areaId;
        this.atLeastNbRoom = atLeastNbRoom;
        this.atLeastNbChest = atLeastNbChest;
        this.skillRequested = skillRequested;
        this.maxPrice = maxPrice;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(areaId);
        buf.writeByte(atLeastNbRoom);
        buf.writeByte(atLeastNbChest);
        buf.writeShort(skillRequested);
        buf.writeInt(maxPrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        areaId = buf.readInt();
        atLeastNbRoom = buf.readByte();
        if (atLeastNbRoom < 0)
            throw new RuntimeException("Forbidden value on atLeastNbRoom = " + atLeastNbRoom + ", it doesn't respect the following condition : atLeastNbRoom < 0");
        atLeastNbChest = buf.readByte();
        if (atLeastNbChest < 0)
            throw new RuntimeException("Forbidden value on atLeastNbChest = " + atLeastNbChest + ", it doesn't respect the following condition : atLeastNbChest < 0");
        skillRequested = buf.readShort();
        if (skillRequested < 0)
            throw new RuntimeException("Forbidden value on skillRequested = " + skillRequested + ", it doesn't respect the following condition : skillRequested < 0");
        maxPrice = buf.readInt();
        if (maxPrice < 0)
            throw new RuntimeException("Forbidden value on maxPrice = " + maxPrice + ", it doesn't respect the following condition : maxPrice < 0");
    }
    
}
