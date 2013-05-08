

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MailStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6275;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short unread;
    public short total;
    
    public MailStatusMessage() { }
    
    public MailStatusMessage(short unread, short total) {
        this.unread = unread;
        this.total = total;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(unread);
        buf.writeShort(total);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        unread = buf.readShort();
        if (unread < 0)
            throw new RuntimeException("Forbidden value on unread = " + unread + ", it doesn't respect the following condition : unread < 0");
        total = buf.readShort();
        if (total < 0)
            throw new RuntimeException("Forbidden value on total = " + total + ", it doesn't respect the following condition : total < 0");
    }
    
}
