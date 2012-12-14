

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectsAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6033;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] object;
    
    public ObjectsAddedMessage() { }
    
    public ObjectsAddedMessage(ObjectItem[] object) {
        this.object = object;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(object.length);
        for (ObjectItem entry : object) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        object = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            object[i] = new ObjectItem();
            object[i].deserialize(reader);
        }
    }
    
}
