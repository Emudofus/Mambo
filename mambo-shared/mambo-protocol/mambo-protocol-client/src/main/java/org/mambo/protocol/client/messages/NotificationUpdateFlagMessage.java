

// Generated on 01/04/2013 14:54:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
