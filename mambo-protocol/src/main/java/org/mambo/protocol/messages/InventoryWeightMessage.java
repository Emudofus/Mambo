

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(weight);
        buf.writeInt(weightMax);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        weight = buf.readInt();
        if (weight < 0)
            throw new RuntimeException("Forbidden value on weight = " + weight + ", it doesn't respect the following condition : weight < 0");
        weightMax = buf.readInt();
        if (weightMax < 0)
            throw new RuntimeException("Forbidden value on weightMax = " + weightMax + ", it doesn't respect the following condition : weightMax < 0");
    }
    
}
