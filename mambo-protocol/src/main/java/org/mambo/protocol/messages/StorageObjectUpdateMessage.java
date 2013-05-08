

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        object.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        object = new ObjectItem();
        object.deserialize(buf);
    }
    
}
