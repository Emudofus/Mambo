

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChatServerCopyMessage extends ChatAbstractServerMessage {
    public static final int MESSAGE_ID = 882;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int receiverId;
    public String receiverName;
    
    public ChatServerCopyMessage() { }
    
    public ChatServerCopyMessage(byte channel, String content, int timestamp, String fingerprint, int receiverId, String receiverName) {
        super(channel, content, timestamp, fingerprint);
        this.receiverId = receiverId;
        this.receiverName = receiverName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(receiverId);
        writer.writeString(receiverName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        receiverId = reader.readInt();
        if (receiverId < 0)
            throw new RuntimeException("Forbidden value on receiverId = " + receiverId + ", it doesn't respect the following condition : receiverId < 0");
        receiverName = reader.readString();
    }
    
}
