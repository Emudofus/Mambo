

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeWeightMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5793;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int currentWeight;
    public int maxWeight;
    
    public ExchangeWeightMessage() { }
    
    public ExchangeWeightMessage(int currentWeight, int maxWeight) {
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(currentWeight);
        buf.writeInt(maxWeight);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        currentWeight = buf.readInt();
        if (currentWeight < 0)
            throw new RuntimeException("Forbidden value on currentWeight = " + currentWeight + ", it doesn't respect the following condition : currentWeight < 0");
        maxWeight = buf.readInt();
        if (maxWeight < 0)
            throw new RuntimeException("Forbidden value on maxWeight = " + maxWeight + ", it doesn't respect the following condition : maxWeight < 0");
    }
    
}
