

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(currentWeight);
        writer.writeInt(maxWeight);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        currentWeight = reader.readInt();
        if (currentWeight < 0)
            throw new RuntimeException("Forbidden value on currentWeight = " + currentWeight + ", it doesn't respect the following condition : currentWeight < 0");
        maxWeight = reader.readInt();
        if (maxWeight < 0)
            throw new RuntimeException("Forbidden value on maxWeight = " + maxWeight + ", it doesn't respect the following condition : maxWeight < 0");
    }
    
}
