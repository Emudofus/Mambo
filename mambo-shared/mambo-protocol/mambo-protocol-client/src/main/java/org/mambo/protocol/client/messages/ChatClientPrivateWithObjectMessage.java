

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class ChatClientPrivateWithObjectMessage extends ChatClientPrivateMessage {
    public static final int MESSAGE_ID = 852;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objects;
    
    public ChatClientPrivateWithObjectMessage() { }
    
    public ChatClientPrivateWithObjectMessage(String content, String receiver, ObjectItem[] objects) {
        super(content, receiver);
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
