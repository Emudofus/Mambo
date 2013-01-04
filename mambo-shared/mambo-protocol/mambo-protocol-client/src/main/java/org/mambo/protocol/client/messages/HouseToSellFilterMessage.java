

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(areaId);
        writer.writeByte(atLeastNbRoom);
        writer.writeByte(atLeastNbChest);
        writer.writeShort(skillRequested);
        writer.writeInt(maxPrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        areaId = reader.readInt();
        atLeastNbRoom = reader.readByte();
        if (atLeastNbRoom < 0)
            throw new RuntimeException("Forbidden value on atLeastNbRoom = " + atLeastNbRoom + ", it doesn't respect the following condition : atLeastNbRoom < 0");
        atLeastNbChest = reader.readByte();
        if (atLeastNbChest < 0)
            throw new RuntimeException("Forbidden value on atLeastNbChest = " + atLeastNbChest + ", it doesn't respect the following condition : atLeastNbChest < 0");
        skillRequested = reader.readShort();
        if (skillRequested < 0)
            throw new RuntimeException("Forbidden value on skillRequested = " + skillRequested + ", it doesn't respect the following condition : skillRequested < 0");
        maxPrice = reader.readInt();
        if (maxPrice < 0)
            throw new RuntimeException("Forbidden value on maxPrice = " + maxPrice + ", it doesn't respect the following condition : maxPrice < 0");
    }
    
}
