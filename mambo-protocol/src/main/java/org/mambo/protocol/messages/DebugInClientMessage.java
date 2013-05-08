

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DebugInClientMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6028;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte level;
    public String message;
    
    public DebugInClientMessage() { }
    
    public DebugInClientMessage(byte level, String message) {
        this.level = level;
        this.message = message;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(level);
        buf.writeString(message);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        level = buf.readByte();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        message = buf.readString();
    }
    
}
