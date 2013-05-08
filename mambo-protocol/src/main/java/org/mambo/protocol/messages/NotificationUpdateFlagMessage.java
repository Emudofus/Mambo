

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(index);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        index = buf.readShort();
        if (index < 0)
            throw new RuntimeException("Forbidden value on index = " + index + ", it doesn't respect the following condition : index < 0");
    }
    
}
