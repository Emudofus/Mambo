

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class QueueStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6100;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int position;
    public int total;
    
    public QueueStatusMessage() { }
    
    public QueueStatusMessage(int position, int total) {
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
