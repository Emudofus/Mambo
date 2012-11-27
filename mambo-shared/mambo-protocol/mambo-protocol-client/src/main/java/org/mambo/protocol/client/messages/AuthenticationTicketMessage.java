

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(lang);
        writer.writeString(ticket);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        lang = reader.readString();
        ticket = reader.readString();
    }
    
}
