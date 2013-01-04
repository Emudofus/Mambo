

// Generated on 01/04/2013 14:54:42
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LoginQueueStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 10;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int position;
    public int total;
    
    public LoginQueueStatusMessage() { }
    
    public LoginQueueStatusMessage(int position, int total) {
        this.position = position;
        this.total = total;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(position);
        writer.writeUnsignedShort(total);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        position = reader.readUnsignedShort();
        if (position < 0 || position > 65535)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 65535");
        total = reader.readUnsignedShort();
        if (total < 0 || total > 65535)
            throw new RuntimeException("Forbidden value on total = " + total + ", it doesn't respect the following condition : total < 0 || total > 65535");
    }
    
}
