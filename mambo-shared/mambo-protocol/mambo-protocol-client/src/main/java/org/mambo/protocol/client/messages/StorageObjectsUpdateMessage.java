

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StorageObjectsUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6036;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] objectList;
    
    public StorageObjectsUpdateMessage() { }
    
    public StorageObjectsUpdateMessage(ObjectItem[] objectList) {
        this.objectList = objectList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objectList.length);
        for (ObjectItem entry : objectList) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objectList = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectList[i] = new ObjectItem();
            objectList[i].deserialize(reader);
        }
    }
    
}
