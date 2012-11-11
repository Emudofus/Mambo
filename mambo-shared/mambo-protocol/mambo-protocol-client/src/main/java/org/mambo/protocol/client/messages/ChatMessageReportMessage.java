

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(senderName);
        writer.writeString(content);
        writer.writeInt(timestamp);
        writer.writeByte(channel);
        writer.writeString(fingerprint);
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        senderName = reader.readString();
        content = reader.readString();
        timestamp = reader.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        channel = reader.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        fingerprint = reader.readString();
        reason = reader.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
