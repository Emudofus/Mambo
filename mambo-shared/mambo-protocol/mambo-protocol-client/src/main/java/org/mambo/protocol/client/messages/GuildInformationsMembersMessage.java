

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildInformationsMembersMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5558;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildMember[] members;
    
    public GuildInformationsMembersMessage() { }
    
    public GuildInformationsMembersMessage(GuildMember[] members) {
        this.members = members;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(members.length);
        for (GuildMember entry : members) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        members = new GuildMember[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = new GuildMember();
            members[i].deserialize(reader);
        }
    }
    
}
