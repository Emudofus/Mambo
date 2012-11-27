

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
