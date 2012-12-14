

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectFeedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6290;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    public int foodUID;
    public short foodQuantity;
    
    public ObjectFeedMessage() { }
    
    public ObjectFeedMessage(int objectUID, int foodUID, short foodQuantity) {
        this.objectUID = objectUID;
        this.foodUID = foodUID;
        this.foodQuantity = foodQuantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectUID);
        writer.writeInt(foodUID);
        writer.writeShort(foodQuantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        foodUID = reader.readInt();
        if (foodUID < 0)
            throw new RuntimeException("Forbidden value on foodUID = " + foodUID + ", it doesn't respect the following condition : foodUID < 0");
        foodQuantity = reader.readShort();
        if (foodQuantity < 0)
            throw new RuntimeException("Forbidden value on foodQuantity = " + foodQuantity + ", it doesn't respect the following condition : foodQuantity < 0");
    }
    
}
