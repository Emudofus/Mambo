

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StorageObjectsRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6035;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] objectUIDList;
    
    public StorageObjectsRemoveMessage() { }
    
    public StorageObjectsRemoveMessage(int[] objectUIDList) {
        this.objectUIDList = objectUIDList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectUIDList.length);
        for (int entry : objectUIDList) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectUIDList = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectUIDList[i] = reader.readInt();
        }
    }
    
}
