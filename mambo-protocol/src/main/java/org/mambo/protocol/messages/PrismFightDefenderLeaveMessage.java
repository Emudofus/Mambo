

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightDefenderLeaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5892;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int fighterToRemoveId;
    public int successor;
    
    public PrismFightDefenderLeaveMessage() { }
    
    public PrismFightDefenderLeaveMessage(double fightId, int fighterToRemoveId, int successor) {
        this.fightId = fightId;
        this.fighterToRemoveId = fighterToRemoveId;
        this.successor = successor;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeInt(fighterToRemoveId);
        buf.writeInt(successor);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        fighterToRemoveId = buf.readInt();
        if (fighterToRemoveId < 0)
            throw new RuntimeException("Forbidden value on fighterToRemoveId = " + fighterToRemoveId + ", it doesn't respect the following condition : fighterToRemoveId < 0");
        successor = buf.readInt();
        if (successor < 0)
            throw new RuntimeException("Forbidden value on successor = " + successor + ", it doesn't respect the following condition : successor < 0");
    }
    
}
