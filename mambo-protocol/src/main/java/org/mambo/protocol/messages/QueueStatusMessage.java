

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(position);
        buf.writeUShort(total);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        position = buf.readUShort();
        if (position < 0 || position > 65535)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 65535");
        total = buf.readUShort();
        if (total < 0 || total > 65535)
            throw new RuntimeException("Forbidden value on total = " + total + ", it doesn't respect the following condition : total < 0 || total > 65535");
    }
    
}
