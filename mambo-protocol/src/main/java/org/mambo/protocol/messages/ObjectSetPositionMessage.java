

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectSetPositionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3021;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    public short position;
    public int quantity;
    
    public ObjectSetPositionMessage() { }
    
    public ObjectSetPositionMessage(int objectUID, short position, int quantity) {
        this.objectUID = objectUID;
        this.position = position;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(objectUID);
        buf.writeUByte(position);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        position = buf.readUByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
