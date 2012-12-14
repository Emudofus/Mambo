

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(unread);
        writer.writeShort(total);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        unread = reader.readShort();
        if (unread < 0)
            throw new RuntimeException("Forbidden value on unread = " + unread + ", it doesn't respect the following condition : unread < 0");
        total = reader.readShort();
        if (total < 0)
            throw new RuntimeException("Forbidden value on total = " + total + ", it doesn't respect the following condition : total < 0");
    }
    
}
