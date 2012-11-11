

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(areaId);
        writer.writeByte(atLeastNbMount);
        writer.writeByte(atLeastNbMachine);
        writer.writeInt(maxPrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        areaId = reader.readInt();
        atLeastNbMount = reader.readByte();
        atLeastNbMachine = reader.readByte();
        maxPrice = reader.readInt();
        if (maxPrice < 0)
            throw new RuntimeException("Forbidden value on maxPrice = " + maxPrice + ", it doesn't respect the following condition : maxPrice < 0");
    }
    
}
