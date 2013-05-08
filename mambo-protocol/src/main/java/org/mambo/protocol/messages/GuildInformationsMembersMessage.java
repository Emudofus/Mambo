

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(members.length);
        for (GuildMember entry : members) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        members = new GuildMember[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = new GuildMember();
            members[i].deserialize(buf);
        }
    }
    
}
