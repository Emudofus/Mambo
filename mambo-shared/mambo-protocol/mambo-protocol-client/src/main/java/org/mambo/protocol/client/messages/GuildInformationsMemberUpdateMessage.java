

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildInformationsMemberUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5597;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GuildMember member;
    
    public GuildInformationsMemberUpdateMessage() { }
    
    public GuildInformationsMemberUpdateMessage(GuildMember member) {
        this.member = member;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        member.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        member = new GuildMember();
        member.deserialize(reader);
    }
    
}
