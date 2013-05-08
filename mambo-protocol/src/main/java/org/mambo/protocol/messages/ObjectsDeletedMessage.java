

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objectUID.length);
        for (int entry : objectUID) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objectUID = new int[limit];
        for (int i = 0; i < limit; i++) {
            objectUID[i] = buf.readInt();
        }
    }
    
}
