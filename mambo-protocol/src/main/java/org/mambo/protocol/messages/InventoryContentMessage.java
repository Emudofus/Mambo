

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(objects.length);
        for (ObjectItem entry : objects) {
            entry.serialize(buf);
        }
        buf.writeInt(kamas);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objects = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new ObjectItem();
            objects[i].deserialize(buf);
        }
        kamas = buf.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
    }
    
}
