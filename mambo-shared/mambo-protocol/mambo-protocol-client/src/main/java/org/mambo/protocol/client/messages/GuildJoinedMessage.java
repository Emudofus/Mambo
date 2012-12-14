

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildJoinedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5564;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildInformations guildInfo;
    public long memberRights;
    public boolean enabled;
    
    public GuildJoinedMessage() { }
    
    public GuildJoinedMessage(GuildInformations guildInfo, long memberRights, boolean enabled) {
        this.guildInfo = guildInfo;
        this.memberRights = memberRights;
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        guildInfo.serialize(writer);
        writer.writeUnsignedInt(memberRights);
        writer.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildInfo = new GuildInformations();
        guildInfo.deserialize(reader);
        memberRights = reader.readUnsignedInt();
        if (memberRights < 0 || memberRights > 4294967295L)
            throw new RuntimeException("Forbidden value on memberRights = " + memberRights + ", it doesn't respect the following condition : memberRights < 0 || memberRights > 4294967295L");
        enabled = reader.readBoolean();
    }
    
}
