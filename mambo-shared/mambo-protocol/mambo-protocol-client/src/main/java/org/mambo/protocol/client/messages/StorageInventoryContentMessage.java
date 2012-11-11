

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StorageInventoryContentMessage extends InventoryContentMessage {
    public static final int MESSAGE_ID = 5646;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public StorageInventoryContentMessage() { }
    
    public StorageInventoryContentMessage(ObjectItem[] objects, int kamas) {
        super(objects, kamas);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
