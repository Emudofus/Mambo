

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
