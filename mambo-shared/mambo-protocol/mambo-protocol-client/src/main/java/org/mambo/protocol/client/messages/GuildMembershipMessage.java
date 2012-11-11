

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildMembershipMessage extends GuildJoinedMessage {
    public static final int MESSAGE_ID = 5835;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public GuildMembershipMessage() { }
    
    public GuildMembershipMessage(GuildInformations guildInfo, long memberRights) {
        super(guildInfo, memberRights);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
