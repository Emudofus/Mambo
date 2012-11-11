

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildMemberOnlineStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6061;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    public boolean online;
    
    public GuildMemberOnlineStatusMessage() { }
    
    public GuildMemberOnlineStatusMessage(int memberId, boolean online) {
        this.memberId = memberId;
        this.online = online;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(memberId);
        writer.writeBoolean(online);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        memberId = reader.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        online = reader.readBoolean();
    }
    
}
