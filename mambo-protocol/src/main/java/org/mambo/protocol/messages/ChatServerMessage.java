

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(senderId);
        buf.writeString(senderName);
        buf.writeInt(senderAccountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        senderId = buf.readInt();
        senderName = buf.readString();
        senderAccountId = buf.readInt();
    }
    
}
