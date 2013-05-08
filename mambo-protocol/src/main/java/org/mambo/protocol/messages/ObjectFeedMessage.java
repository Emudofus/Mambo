

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(objectUID);
        buf.writeInt(foodUID);
        buf.writeShort(foodQuantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        foodUID = buf.readInt();
        if (foodUID < 0)
            throw new RuntimeException("Forbidden value on foodUID = " + foodUID + ", it doesn't respect the following condition : foodUID < 0");
        foodQuantity = buf.readShort();
        if (foodQuantity < 0)
            throw new RuntimeException("Forbidden value on foodQuantity = " + foodQuantity + ", it doesn't respect the following condition : foodQuantity < 0");
    }
    
}
