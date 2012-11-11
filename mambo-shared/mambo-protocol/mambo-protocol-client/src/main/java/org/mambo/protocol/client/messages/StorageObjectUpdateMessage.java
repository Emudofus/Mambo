

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StorageObjectUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5647;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public StorageObjectUpdateMessage() { }
    
    public StorageObjectUpdateMessage(ObjectItem object) {
        this.object = object;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        object.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        object = new ObjectItem();
        object.deserialize(reader);
    }
    
}
