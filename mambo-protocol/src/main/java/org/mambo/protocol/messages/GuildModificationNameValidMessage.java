

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildModificationNameValidMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6327;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String guildName;
    
    public GuildModificationNameValidMessage() { }
    
    public GuildModificationNameValidMessage(String guildName) {
        this.guildName = guildName;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(guildName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildName = buf.readString();
    }
    
}
