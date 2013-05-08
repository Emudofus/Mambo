

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import org.mambo.core.io.Buffer;
import org.mambo.protocol.NetworkMessage;

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
    public void serialize(Buffer buf) {
        buf.writeByte(type);
        buf.writeString(content);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        content = buf.readString();
    }
    
}
