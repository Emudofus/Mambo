

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(level);
        writer.writeString(message);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        level = reader.readByte();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        message = reader.readString();
    }
    
}
