

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectUseMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3019;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    
    public ObjectUseMessage() { }
    
    public ObjectUseMessage(int objectUID) {
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
