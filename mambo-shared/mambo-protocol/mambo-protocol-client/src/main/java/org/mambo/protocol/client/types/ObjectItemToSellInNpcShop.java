

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(objectPrice);
        writer.writeString(buyCriterion);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        objectPrice = reader.readInt();
        if (objectPrice < 0)
            throw new RuntimeException("Forbidden value on objectPrice = " + objectPrice + ", it doesn't respect the following condition : objectPrice < 0");
        buyCriterion = reader.readString();
    }
    
}
