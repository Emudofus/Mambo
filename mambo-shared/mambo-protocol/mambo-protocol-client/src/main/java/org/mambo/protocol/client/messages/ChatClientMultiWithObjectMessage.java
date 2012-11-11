

// Generated on 11/11/2012 19:17:00
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ChatClientMultiWithObjectMessage extends ChatClientMultiMessage {
    public static final int MESSAGE_ID = 862;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objects;
    
    public ChatClientMultiWithObjectMessage() { }
    
    public ChatClientMultiWithObjectMessage(String content, byte channel, ObjectItem[] objects) {
        super(content, channel);
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
