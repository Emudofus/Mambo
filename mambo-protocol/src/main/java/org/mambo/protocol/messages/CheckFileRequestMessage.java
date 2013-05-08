

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CheckFileRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6154;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String filename;
    public byte type;
    
    public CheckFileRequestMessage() { }
    
    public CheckFileRequestMessage(String filename, byte type) {
        this.filename = filename;
        this.type = type;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(filename);
        buf.writeByte(type);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        filename = buf.readString();
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
