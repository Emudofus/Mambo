

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class UpdateLifePointsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5658;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int lifePoints;
    public int maxLifePoints;
    
    public UpdateLifePointsMessage() { }
    
    public UpdateLifePointsMessage(int lifePoints, int maxLifePoints) {
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        lifePoints = reader.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = reader.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
    }
    
}
