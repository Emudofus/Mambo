

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectsUIDAndQty.length);
        for (ObjectItemQuantity entry : objectsUIDAndQty) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectsUIDAndQty = new ObjectItemQuantity[limit];
        for (int i = 0; i < limit; i++) {
            objectsUIDAndQty[i] = new ObjectItemQuantity();
            objectsUIDAndQty[i].deserialize(reader);
        }
    }
    
}
