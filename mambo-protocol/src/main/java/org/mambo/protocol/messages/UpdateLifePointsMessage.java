

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(lifePoints);
        buf.writeInt(maxLifePoints);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        lifePoints = buf.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = buf.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
    }
    
}
