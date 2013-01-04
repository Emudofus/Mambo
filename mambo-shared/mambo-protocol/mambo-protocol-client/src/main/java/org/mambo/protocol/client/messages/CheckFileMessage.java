

// Generated on 01/04/2013 14:54:42
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(filenameHash);
        writer.writeByte(type);
        writer.writeString(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        filenameHash = reader.readString();
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        value = reader.readString();
    }
    
}
