

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        guildEmblem.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildEmblem = new GuildEmblem();
        guildEmblem.deserialize(reader);
    }
    
}
