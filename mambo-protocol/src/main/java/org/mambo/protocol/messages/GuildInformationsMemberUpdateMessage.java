

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        member.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        member = new GuildMember();
        member.deserialize(buf);
    }
    
}
