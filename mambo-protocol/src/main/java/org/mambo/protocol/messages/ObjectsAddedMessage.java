

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectsAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6033;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem[] object;
    
    public ObjectsAddedMessage() { }
    
    public ObjectsAddedMessage(ObjectItem[] object) {
        this.object = object;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(object.length);
        for (ObjectItem entry : object) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        object = new ObjectItem[limit];
        for (int i = 0; i < limit; i++) {
            object[i] = new ObjectItem();
            object[i].deserialize(buf);
        }
    }
    
}
