

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objectUIDList.length);
        for (int entry : objectUIDList) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectUIDList = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectUIDList[i] = buf.readInt();
        }
    }
    
}
