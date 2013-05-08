

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatAbstractServerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 880;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte channel;
    public String content;
    public int timestamp;
    public String fingerprint;
    
    public ChatAbstractServerMessage() { }
    
    public ChatAbstractServerMessage(byte channel, String content, int timestamp, String fingerprint) {
        this.channel = channel;
        this.content = content;
        this.timestamp = timestamp;
        this.fingerprint = fingerprint;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(channel);
        buf.writeString(content);
        buf.writeInt(timestamp);
        buf.writeString(fingerprint);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        channel = buf.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        content = buf.readString();
        timestamp = buf.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        fingerprint = buf.readString();
    }
    
}
