

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildKickRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5887;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kickedId;
    
    public GuildKickRequestMessage() { }
    
    public GuildKickRequestMessage(int kickedId) {
        this.kickedId = kickedId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(kickedId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        kickedId = buf.readInt();
        if (kickedId < 0)
            throw new RuntimeException("Forbidden value on kickedId = " + kickedId + ", it doesn't respect the following condition : kickedId < 0");
    }
    
}
