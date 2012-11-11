

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ChatServerMessage extends ChatAbstractServerMessage {
    public static final int MESSAGE_ID = 881;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int senderId;
    public String senderName;
    public int senderAccountId;
    
    public ChatServerMessage() { }
    
    public ChatServerMessage(byte channel, String content, int timestamp, String fingerprint, int senderId, String senderName, int senderAccountId) {
        super(channel, content, timestamp, fingerprint);
        this.senderId = senderId;
        this.senderName = senderName;
        this.senderAccountId = senderAccountId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(senderId);
        writer.writeString(senderName);
        writer.writeInt(senderAccountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        senderId = reader.readInt();
        senderName = reader.readString();
        senderAccountId = reader.readInt();
    }
    
}
