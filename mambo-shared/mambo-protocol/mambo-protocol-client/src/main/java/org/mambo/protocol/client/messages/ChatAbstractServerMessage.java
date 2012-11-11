

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(channel);
        writer.writeString(content);
        writer.writeInt(timestamp);
        writer.writeString(fingerprint);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        channel = reader.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
        content = reader.readString();
        timestamp = reader.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        fingerprint = reader.readString();
    }
    
}
