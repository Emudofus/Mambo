

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildInvitedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5552;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int recruterId;
    public String recruterName;
    public BasicGuildInformations guildInfo;
    
    public GuildInvitedMessage() { }
    
    public GuildInvitedMessage(int recruterId, String recruterName, BasicGuildInformations guildInfo) {
        this.recruterId = recruterId;
        this.recruterName = recruterName;
        this.guildInfo = guildInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(recruterId);
        writer.writeString(recruterName);
        guildInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        recruterId = reader.readInt();
        if (recruterId < 0)
            throw new RuntimeException("Forbidden value on recruterId = " + recruterId + ", it doesn't respect the following condition : recruterId < 0");
        recruterName = reader.readString();
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(reader);
    }
    
}
