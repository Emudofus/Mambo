

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightJoinRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 701;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fighterId;
    public int fightId;
    
    public GameFightJoinRequestMessage() { }
    
    public GameFightJoinRequestMessage(int fighterId, int fightId) {
        this.fighterId = fighterId;
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fighterId);
        buf.writeInt(fightId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fighterId = buf.readInt();
        fightId = buf.readInt();
    }
    
}
