

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeString(salt);
        buf.writeUShort(key.length);
        for (byte entry : key) {
            buf.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        salt = buf.readString();
        int limit = buf.readUShort();
        key = new byte[limit];
        for (int i = 0; i < limit; i++) {
            key[i] = buf.readByte();
        }
    }
    
}
