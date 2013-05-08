

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(receiverId);
        buf.writeString(receiverName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        receiverId = buf.readInt();
        if (receiverId < 0)
            throw new RuntimeException("Forbidden value on receiverId = " + receiverId + ", it doesn't respect the following condition : receiverId < 0");
        receiverName = buf.readString();
    }
    
}
