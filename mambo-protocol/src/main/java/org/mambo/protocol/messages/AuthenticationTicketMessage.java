

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AuthenticationTicketMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 110;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String lang;
    public String ticket;
    
    public AuthenticationTicketMessage() { }
    
    public AuthenticationTicketMessage(String lang, String ticket) {
        this.lang = lang;
        this.ticket = ticket;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(lang);
        buf.writeString(ticket);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        lang = buf.readString();
        ticket = buf.readString();
    }
    
}
