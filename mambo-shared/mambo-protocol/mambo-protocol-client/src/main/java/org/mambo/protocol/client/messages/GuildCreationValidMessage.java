

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildCreationValidMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5546;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String guildName;
    public GuildEmblem guildEmblem;
    
    public GuildCreationValidMessage() { }
    
    public GuildCreationValidMessage(String guildName, GuildEmblem guildEmblem) {
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
