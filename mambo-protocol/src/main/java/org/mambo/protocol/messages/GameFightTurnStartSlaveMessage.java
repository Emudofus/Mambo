

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightTurnStartSlaveMessage extends GameFightTurnStartMessage {
    public static final int MESSAGE_ID = 6213;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int idSummoner;
    
    public GameFightTurnStartSlaveMessage() { }
    
    public GameFightTurnStartSlaveMessage(int id, int waitTime, int idSummoner) {
        super(id, waitTime);
        this.idSummoner = idSummoner;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(idSummoner);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        idSummoner = buf.readInt();
    }
    
}
