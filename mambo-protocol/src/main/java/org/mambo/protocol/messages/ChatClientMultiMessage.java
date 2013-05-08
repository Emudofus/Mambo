

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatClientMultiMessage extends ChatAbstractClientMessage {
    public static final int MESSAGE_ID = 861;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte channel;
    
    public ChatClientMultiMessage() { }
    
    public ChatClientMultiMessage(String content, byte channel) {
        super(content);
        this.channel = channel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(channel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        channel = buf.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
    }
    
}
