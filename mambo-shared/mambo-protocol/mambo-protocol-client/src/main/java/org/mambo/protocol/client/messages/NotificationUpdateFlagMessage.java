

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
