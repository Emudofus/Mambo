

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(objectUID);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
