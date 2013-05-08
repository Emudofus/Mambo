

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightReduceDamagesMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5526;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public int amount;
    
    public GameActionFightReduceDamagesMessage() { }
    
    public GameActionFightReduceDamagesMessage(short actionId, int sourceId, int targetId, int amount) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.amount = amount;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeInt(amount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        amount = buf.readInt();
        if (amount < 0)
            throw new RuntimeException("Forbidden value on amount = " + amount + ", it doesn't respect the following condition : amount < 0");
    }
    
}
