

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CheckFileMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6156;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String filenameHash;
    public byte type;
    public String value;
    
    public CheckFileMessage() { }
    
    public CheckFileMessage(String filenameHash, byte type, String value) {
        this.filenameHash = filenameHash;
        this.type = type;
        this.value = value;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(filenameHash);
        buf.writeByte(type);
        buf.writeString(value);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        filenameHash = buf.readString();
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        value = buf.readString();
    }
    
}
