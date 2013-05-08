

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatMessageReportMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 821;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String senderName;
    public String content;
    public int timestamp;
    public byte channel;
    public String fingerprint;
    public byte reason;
    
    public ChatMessageReportMessage() { }
    
    public ChatMessageReportMessage(String senderName, String content, int timestamp, byte channel, String fingerprint, byte reason) {
        this.senderName = senderName;
        this.content = content;
        this.timestamp = timestamp;
        this.channel = channel;
        this.fingerprint = fingerprint;
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(senderName);
        buf.writeString(content);
        buf.writeInt(timestamp);
        buf.writeByte(channel);
        buf.writeString(fingerprint);
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        senderName = buf.readString();
        content = buf.readString();
        timestamp = buf.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        channel = buf.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        fingerprint = buf.readString();
        reason = buf.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
