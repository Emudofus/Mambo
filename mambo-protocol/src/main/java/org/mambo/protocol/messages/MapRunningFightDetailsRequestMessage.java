

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapRunningFightDetailsRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5750;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    
    public MapRunningFightDetailsRequestMessage() { }
    
    public MapRunningFightDetailsRequestMessage(int fightId) {
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
    }
    
}
