

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightNewRoundMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6239;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int roundNumber;
    
    public GameFightNewRoundMessage() { }
    
    public GameFightNewRoundMessage(int roundNumber) {
        this.roundNumber = roundNumber;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(roundNumber);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        roundNumber = buf.readInt();
        if (roundNumber < 0)
            throw new RuntimeException("Forbidden value on roundNumber = " + roundNumber + ", it doesn't respect the following condition : roundNumber < 0");
    }
    
}
