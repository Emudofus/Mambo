

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryWeightMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3009;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int weight;
    public int weightMax;
    
    public InventoryWeightMessage() { }
    
    public InventoryWeightMessage(int weight, int weightMax) {
        this.weight = weight;
        this.weightMax = weightMax;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(weight);
        writer.writeInt(weightMax);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        weight = reader.readInt();
        if (weight < 0)
            throw new RuntimeException("Forbidden value on weight = " + weight + ", it doesn't respect the following condition : weight < 0");
        weightMax = reader.readInt();
        if (weightMax < 0)
            throw new RuntimeException("Forbidden value on weightMax = " + weightMax + ", it doesn't respect the following condition : weightMax < 0");
    }
    
}
