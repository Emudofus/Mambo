

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInvitedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5552;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int recruterId;
    public String recruterName;
    public BasicGuildInformations guildInfo;
    
    public GuildInvitedMessage() { }
    
    public GuildInvitedMessage(int recruterId, String recruterName, BasicGuildInformations guildInfo) {
        this.recruterId = recruterId;
        this.recruterName = recruterName;
        this.guildInfo = guildInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(recruterId);
        buf.writeString(recruterName);
        guildInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        recruterId = buf.readInt();
        if (recruterId < 0)
            throw new RuntimeException("Forbidden value on recruterId = " + recruterId + ", it doesn't respect the following condition : recruterId < 0");
        recruterName = buf.readString();
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(buf);
    }
    
}
