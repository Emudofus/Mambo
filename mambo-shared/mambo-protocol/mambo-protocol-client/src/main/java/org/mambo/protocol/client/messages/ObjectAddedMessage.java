

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3025;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public ObjectAddedMessage() { }
    
    public ObjectAddedMessage(ObjectItem object) {
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
