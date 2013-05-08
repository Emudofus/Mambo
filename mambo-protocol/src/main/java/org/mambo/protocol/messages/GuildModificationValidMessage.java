

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildModificationValidMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6323;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String guildName;
    public GuildEmblem guildEmblem;
    
    public GuildModificationValidMessage() { }
    
    public GuildModificationValidMessage(String guildName, GuildEmblem guildEmblem) {
        this.guildName = guildName;
        this.guildEmblem = guildEmblem;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(guildName);
        guildEmblem.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildName = buf.readString();
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(buf);
    }
    
}
