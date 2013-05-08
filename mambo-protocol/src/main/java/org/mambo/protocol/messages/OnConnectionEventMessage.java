

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class OnConnectionEventMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5726;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte eventType;
    
    public OnConnectionEventMessage() { }
    
    public OnConnectionEventMessage(byte eventType) {
        this.eventType = eventType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(eventType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        eventType = buf.readByte();
        if (eventType < 0)
            throw new RuntimeException("Forbidden value on eventType = " + eventType + ", it doesn't respect the following condition : eventType < 0");
    }
    
}
