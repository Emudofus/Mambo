

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class StorageObjectRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5648;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    
    public StorageObjectRemoveMessage() { }
    
    public StorageObjectRemoveMessage(int objectUID) {
        this.objectUID = objectUID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
