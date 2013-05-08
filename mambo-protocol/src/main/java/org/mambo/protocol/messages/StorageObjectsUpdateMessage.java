

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objectList.length);
        for (ObjectItem entry : objectList) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectList = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            objectList[i] = new ObjectItem();
            objectList[i].deserialize(buf);
        }
    }
    
}
