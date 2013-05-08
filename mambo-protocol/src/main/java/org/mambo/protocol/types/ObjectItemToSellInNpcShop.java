

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation {
    public static final short TYPE_ID = 352;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int objectPrice;
    public String buyCriterion;
    
    public ObjectItemToSellInNpcShop() { }
    
    public ObjectItemToSellInNpcShop(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int objectPrice, String buyCriterion) {
        super(objectGID, powerRate, overMax, effects);
        this.objectPrice = objectPrice;
        this.buyCriterion = buyCriterion;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(objectPrice);
        buf.writeString(buyCriterion);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectPrice = buf.readInt();
        if (objectPrice < 0)
            throw new RuntimeException("Forbidden value on objectPrice = " + objectPrice + ", it doesn't respect the following condition : objectPrice < 0");
        buyCriterion = buf.readString();
    }
    
}
