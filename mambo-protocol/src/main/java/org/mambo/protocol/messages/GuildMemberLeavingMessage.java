

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildMemberLeavingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5923;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean kicked;
    public int memberId;
    
    public GuildMemberLeavingMessage() { }
    
    public GuildMemberLeavingMessage(boolean kicked, int memberId) {
        this.kicked = kicked;
        this.memberId = memberId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(kicked);
        buf.writeInt(memberId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        kicked = buf.readBoolean();
        memberId = buf.readInt();
    }
    
}
