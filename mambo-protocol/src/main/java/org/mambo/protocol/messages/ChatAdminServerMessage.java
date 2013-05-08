

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatAdminServerMessage extends ChatServerMessage {
    public static final int MESSAGE_ID = 6135;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public ChatAdminServerMessage() { }
    
    public ChatAdminServerMessage(byte channel, String content, int timestamp, String fingerprint, int senderId, String senderName, int senderAccountId) {
        super(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
