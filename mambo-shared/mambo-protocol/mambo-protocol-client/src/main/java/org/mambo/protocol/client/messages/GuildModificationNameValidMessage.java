

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(guildName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildName = reader.readString();
    }
    
}
