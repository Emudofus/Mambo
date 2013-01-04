

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(attackerId);
        writer.writeInt(defenderId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        attackerId = reader.readInt();
        if (attackerId < 0)
            throw new RuntimeException("Forbidden value on attackerId = " + attackerId + ", it doesn't respect the following condition : attackerId < 0");
        defenderId = reader.readInt();
        if (defenderId < 0)
            throw new RuntimeException("Forbidden value on defenderId = " + defenderId + ", it doesn't respect the following condition : defenderId < 0");
    }
    
}
