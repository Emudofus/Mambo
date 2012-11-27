

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class NotificationUpdateFlagMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6090;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short index;
    
    public NotificationUpdateFlagMessage() { }
    
    public NotificationUpdateFlagMessage(short index) {
        this.index = index;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(index);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        index = reader.readShort();
        if (index < 0)
            throw new RuntimeException("Forbidden value on index = " + index + ", it doesn't respect the following condition : index < 0");
    }
    
}
