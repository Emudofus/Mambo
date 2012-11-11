

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class HouseToSellFilterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6137;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int areaId;
    public byte atLeastNbRoom;
    public byte atLeastNbChest;
    public byte skillRequested;
    public int maxPrice;
    
    public HouseToSellFilterMessage() { }
    
    public HouseToSellFilterMessage(int areaId, byte atLeastNbRoom, byte atLeastNbChest, byte skillRequested, int maxPrice) {
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
        writer.writeByte(skillRequested);
        writer.writeInt(maxPrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        areaId = reader.readInt();
        atLeastNbRoom = reader.readByte();
        atLeastNbChest = reader.readByte();
        skillRequested = reader.readByte();
        maxPrice = reader.readInt();
        if (maxPrice < 0)
            throw new RuntimeException("Forbidden value on maxPrice = " + maxPrice + ", it doesn't respect the following condition : maxPrice < 0");
    }
    
}
