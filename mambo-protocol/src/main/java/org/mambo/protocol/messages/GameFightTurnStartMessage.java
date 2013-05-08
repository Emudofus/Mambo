

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightTurnStartMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 714;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    public int waitTime;
    
    public GameFightTurnStartMessage() { }
    
    public GameFightTurnStartMessage(int id, int waitTime) {
        this.id = id;
        this.waitTime = waitTime;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        buf.writeInt(waitTime);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        waitTime = buf.readInt();
        if (waitTime < 0)
            throw new RuntimeException("Forbidden value on waitTime = " + waitTime + ", it doesn't respect the following condition : waitTime < 0");
    }
    
}
