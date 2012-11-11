

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectsDeletedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6034;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] objectUID;
    
    public ObjectsDeletedMessage() { }
    
    public ObjectsDeletedMessage(int[] objectUID) {
        this.objectUID = objectUID;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectUID.length);
        for (int entry : objectUID) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectUID = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectUID[i] = reader.readInt();
        }
    }
    
}
