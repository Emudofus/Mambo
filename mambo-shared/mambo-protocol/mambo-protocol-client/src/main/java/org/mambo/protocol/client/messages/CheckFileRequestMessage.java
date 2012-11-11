

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(filename);
        writer.writeByte(type);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        filename = reader.readString();
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
