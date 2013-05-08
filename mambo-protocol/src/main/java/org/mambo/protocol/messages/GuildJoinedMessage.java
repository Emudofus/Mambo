

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildJoinedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5564;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildInformations guildInfo;
    public long memberRights;
    public boolean enabled;
    
    public GuildJoinedMessage() { }
    
    public GuildJoinedMessage(GuildInformations guildInfo, long memberRights, boolean enabled) {
        this.guildInfo = guildInfo;
        this.memberRights = memberRights;
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(Buffer buf) {
        guildInfo.serialize(buf);
        buf.writeUInt(memberRights);
        buf.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildInfo = new GuildInformations();
        guildInfo.deserialize(buf);
        memberRights = buf.readUInt();
        if (memberRights < 0 || memberRights > 4294967295L)
            throw new RuntimeException("Forbidden value on memberRights = " + memberRights + ", it doesn't respect the following condition : memberRights < 0 || memberRights > 4294967295L");
        enabled = buf.readBoolean();
    }
    
}
