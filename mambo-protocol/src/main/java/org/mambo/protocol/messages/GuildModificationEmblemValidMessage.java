

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildModificationEmblemValidMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6328;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildEmblem guildEmblem;
    
    public GuildModificationEmblemValidMessage() { }
    
    public GuildModificationEmblemValidMessage(GuildEmblem guildEmblem) {
        this.guildEmblem = guildEmblem;
    }
    
    @Override
    public void serialize(Buffer buf) {
        guildEmblem.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(buf);
    }
    
}
