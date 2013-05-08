

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportBuddiesAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6294;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean accept;
    
    public TeleportBuddiesAnswerMessage() { }
    
    public TeleportBuddiesAnswerMessage(boolean accept) {
        this.accept = accept;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(accept);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accept = buf.readBoolean();
    }
    
}
