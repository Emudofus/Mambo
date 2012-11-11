

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
