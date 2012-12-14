

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectItemInformationWithQuantity extends ObjectItemMinimalInformation {
    public static final short TYPE_ID = 387;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int quantity;
    
    public ObjectItemInformationWithQuantity() { }
    
    public ObjectItemInformationWithQuantity(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int quantity) {
        super(objectGID, powerRate, overMax, effects);
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
