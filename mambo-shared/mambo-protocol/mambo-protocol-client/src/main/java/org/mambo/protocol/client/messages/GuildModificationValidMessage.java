

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
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
