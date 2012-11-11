

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ConsoleMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 75;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte type;
    public String content;
    
    public ConsoleMessage() { }
    
    public ConsoleMessage(byte type, String content) {
        this.type = type;
        this.content = content;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(type);
        writer.writeString(content);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        content = reader.readString();
    }
    
}
