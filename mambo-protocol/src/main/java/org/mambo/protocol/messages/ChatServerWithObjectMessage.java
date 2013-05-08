

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChatServerWithObjectMessage extends ChatServerMessage {
    public static final int MESSAGE_ID = 883;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objects;
    
    public ChatServerWithObjectMessage() { }
    
    public ChatServerWithObjectMessage(byte channel, String content, int timestamp, String fingerprint, int senderId, String senderName, int senderAccountId, ObjectItem[] objects) {
        super(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId);
        this.objects = objects;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(objects.length);
        for (ObjectItem entry : objects) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        objects = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new ObjectItem();
            objects[i].deserialize(buf);
        }
    }
    
}
