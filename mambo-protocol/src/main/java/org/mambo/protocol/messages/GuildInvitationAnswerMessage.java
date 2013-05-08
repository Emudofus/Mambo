

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInvitationAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5556;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean accept;
    
    public GuildInvitationAnswerMessage() { }
    
    public GuildInvitationAnswerMessage(boolean accept) {
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
