

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectItemQuantity extends Item {
    public static final short TYPE_ID = 119;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int objectUID;
    public int quantity;
    
    public ObjectItemQuantity() { }
    
    public ObjectItemQuantity(int objectUID, int quantity) {
        this.objectUID = objectUID;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(objectUID);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
