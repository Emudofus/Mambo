

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightTurnEndMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 719;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    
    public GameFightTurnEndMessage() { }
    
    public GameFightTurnEndMessage(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
    }
    
}
