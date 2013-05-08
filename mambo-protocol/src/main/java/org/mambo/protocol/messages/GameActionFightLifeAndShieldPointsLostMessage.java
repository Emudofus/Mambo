

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage {
    public static final int MESSAGE_ID = 6310;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short shieldLoss;
    
    public GameActionFightLifeAndShieldPointsLostMessage() { }
    
    public GameActionFightLifeAndShieldPointsLostMessage(short actionId, int sourceId, int targetId, short loss, short permanentDamages, short shieldLoss) {
        super(actionId, sourceId, targetId, loss, permanentDamages);
        this.shieldLoss = shieldLoss;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(shieldLoss);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        shieldLoss = buf.readShort();
        if (shieldLoss < 0)
            throw new RuntimeException("Forbidden value on shieldLoss = " + shieldLoss + ", it doesn't respect the following condition : shieldLoss < 0");
    }
    
}
