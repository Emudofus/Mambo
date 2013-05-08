

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightLeaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 721;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int charId;
    
    public GameFightLeaveMessage() { }
    
    public GameFightLeaveMessage(int charId) {
        this.charId = charId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(charId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        charId = buf.readInt();
    }
    
}
