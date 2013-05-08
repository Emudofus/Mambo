

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 708;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean isReady;
    
    public GameFightReadyMessage() { }
    
    public GameFightReadyMessage(boolean isReady) {
        this.isReady = isReady;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(isReady);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        isReady = buf.readBoolean();
    }
    
}
