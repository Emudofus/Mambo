

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChatServerCopyWithObjectMessage extends ChatServerCopyMessage {
    public static final int MESSAGE_ID = 884;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objects;
    
    public ChatServerCopyWithObjectMessage() { }
    
    public ChatServerCopyWithObjectMessage(byte channel, String content, int timestamp, String fingerprint, int receiverId, String receiverName, ObjectItem[] objects) {
        super(channel, content, timestamp, fingerprint, receiverId, receiverName);
        this.objects = objects;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(objects.length);
        for (ObjectItem entry : objects) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        objects = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new ObjectItem();
            objects[i].deserialize(reader);
        }
    }
    
}
