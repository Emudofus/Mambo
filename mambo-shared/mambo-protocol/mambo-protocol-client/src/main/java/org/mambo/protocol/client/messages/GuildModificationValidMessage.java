

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(guildName);
        guildEmblem.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildName = reader.readString();
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(reader);
    }
    
}
