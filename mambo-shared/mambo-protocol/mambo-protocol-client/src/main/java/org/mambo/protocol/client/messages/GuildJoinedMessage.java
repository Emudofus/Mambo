

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildJoinedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5564;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildInformations guildInfo;
    public long memberRights;
    
    public GuildJoinedMessage() { }
    
    public GuildJoinedMessage(GuildInformations guildInfo, long memberRights) {
        this.guildInfo = guildInfo;
        this.memberRights = memberRights;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        guildInfo.serialize(writer);
        writer.writeUnsignedInt(memberRights);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildInfo = new GuildInformations();
        guildInfo.deserialize(reader);
        memberRights = reader.readUnsignedInt();
        if (memberRights < 0 || memberRights > 4294967295L)
            throw new RuntimeException("Forbidden value on memberRights = " + memberRights + ", it doesn't respect the following condition : memberRights < 0 || memberRights > 4294967295L");
    }
    
}
