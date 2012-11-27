

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class LifePointsRegenEndMessage extends UpdateLifePointsMessage {
    public static final int MESSAGE_ID = 5686;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int lifePointsGained;
    
    public LifePointsRegenEndMessage() { }
    
    public LifePointsRegenEndMessage(int lifePoints, int maxLifePoints, int lifePointsGained) {
        super(lifePoints, maxLifePoints);
        this.lifePointsGained = lifePointsGained;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(lifePointsGained);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        lifePointsGained = reader.readInt();
        if (lifePointsGained < 0)
            throw new RuntimeException("Forbidden value on lifePointsGained = " + lifePointsGained + ", it doesn't respect the following condition : lifePointsGained < 0");
    }
    
}
