

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
