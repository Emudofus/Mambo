

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayAggressionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6073;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int attackerId;
    public int defenderId;
    
    public GameRolePlayAggressionMessage() { }
    
    public GameRolePlayAggressionMessage(int attackerId, int defenderId) {
        this.attackerId = attackerId;
        this.defenderId = defenderId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(attackerId);
        buf.writeInt(defenderId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        attackerId = buf.readInt();
        if (attackerId < 0)
            throw new RuntimeException("Forbidden value on attackerId = " + attackerId + ", it doesn't respect the following condition : attackerId < 0");
        defenderId = buf.readInt();
        if (defenderId < 0)
            throw new RuntimeException("Forbidden value on defenderId = " + defenderId + ", it doesn't respect the following condition : defenderId < 0");
    }
    
}
