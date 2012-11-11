

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectModifiedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3029;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public ObjectModifiedMessage() { }
    
    public ObjectModifiedMessage(ObjectItem object) {
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
