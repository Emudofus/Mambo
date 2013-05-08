

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(lifePointsGained);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        lifePointsGained = buf.readInt();
        if (lifePointsGained < 0)
            throw new RuntimeException("Forbidden value on lifePointsGained = " + lifePointsGained + ", it doesn't respect the following condition : lifePointsGained < 0");
    }
    
}
