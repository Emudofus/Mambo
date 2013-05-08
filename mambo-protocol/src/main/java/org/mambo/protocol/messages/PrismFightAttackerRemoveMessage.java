

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightAttackerRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5897;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int fighterToRemoveId;
    
    public PrismFightAttackerRemoveMessage() { }
    
    public PrismFightAttackerRemoveMessage(double fightId, int fighterToRemoveId) {
        this.fightId = fightId;
        this.fighterToRemoveId = fighterToRemoveId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeInt(fighterToRemoveId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        fighterToRemoveId = buf.readInt();
        if (fighterToRemoveId < 0)
            throw new RuntimeException("Forbidden value on fighterToRemoveId = " + fighterToRemoveId + ", it doesn't respect the following condition : fighterToRemoveId < 0");
    }
    
}
