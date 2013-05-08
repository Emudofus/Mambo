

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildMembershipMessage extends GuildJoinedMessage {
    public static final int MESSAGE_ID = 5835;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public GuildMembershipMessage() { }
    
    public GuildMembershipMessage(GuildInformations guildInfo, long memberRights, boolean enabled) {
        super(guildInfo, memberRights, enabled);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
