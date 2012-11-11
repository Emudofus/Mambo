

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryContentMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3016;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objects;
    public int kamas;
    
    public InventoryContentMessage() { }
    
    public InventoryContentMessage(ObjectItem[] objects, int kamas) {
        this.objects = objects;
        this.kamas = kamas;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objects.length);
        for (ObjectItem entry : objects) {
            entry.serialize(writer);
        }
        writer.writeInt(kamas);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objects = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new ObjectItem();
            objects[i].deserialize(reader);
        }
        kamas = reader.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
    }
    
}
