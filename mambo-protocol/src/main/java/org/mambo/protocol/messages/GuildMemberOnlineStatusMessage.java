

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildMemberOnlineStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6061;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    public boolean online;
    
    public GuildMemberOnlineStatusMessage() { }
    
    public GuildMemberOnlineStatusMessage(int memberId, boolean online) {
        this.memberId = memberId;
        this.online = online;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(memberId);
        buf.writeBoolean(online);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        memberId = buf.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        online = buf.readBoolean();
    }
    
}
