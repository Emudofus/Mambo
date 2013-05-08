

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
