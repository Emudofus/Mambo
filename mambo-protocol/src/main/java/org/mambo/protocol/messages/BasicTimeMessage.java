

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicTimeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 175;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int timestamp;
    public short timezoneOffset;
    
    public BasicTimeMessage() { }
    
    public BasicTimeMessage(int timestamp, short timezoneOffset) {
        this.timestamp = timestamp;
        this.timezoneOffset = timezoneOffset;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(timestamp);
        buf.writeShort(timezoneOffset);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        timestamp = buf.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        timezoneOffset = buf.readShort();
    }
    
}
