

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectsQuantityMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6206;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemQuantity[] objectsUIDAndQty;
    
    public ObjectsQuantityMessage() { }
    
    public ObjectsQuantityMessage(ObjectItemQuantity[] objectsUIDAndQty) {
        this.objectsUIDAndQty = objectsUIDAndQty;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(objectsUIDAndQty.length);
        for (ObjectItemQuantity entry : objectsUIDAndQty) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectsUIDAndQty = new ObjectItemQuantity[limit];
        for (int i = 0; i < limit; i++) {
            objectsUIDAndQty[i] = new ObjectItemQuantity();
            objectsUIDAndQty[i].deserialize(buf);
        }
    }
    
}
