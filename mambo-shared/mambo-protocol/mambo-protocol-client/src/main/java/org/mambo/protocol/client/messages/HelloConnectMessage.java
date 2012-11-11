

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class HelloConnectMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String salt;
    public byte[] key;
    
    public HelloConnectMessage() { }
    
    public HelloConnectMessage(String salt, byte[] key) {
        this.salt = salt;
        this.key = key;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(salt);
        writer.writeUnsignedShort(key.length);
        for (byte entry : key) {
            writer.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        salt = reader.readString();
        int limit = reader.readUnsignedShort();
        key = new byte[limit];
        for (int i = 0; i < limit; i++) {
            key[i] = reader.readByte();
        }
    }
    
}
