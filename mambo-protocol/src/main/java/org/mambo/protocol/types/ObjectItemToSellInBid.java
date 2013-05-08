

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectItemToSellInBid extends ObjectItemToSell {
    public static final short TYPE_ID = 164;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short unsoldDelay;
    
    public ObjectItemToSellInBid() { }
    
    public ObjectItemToSellInBid(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int objectUID, int quantity, int objectPrice, short unsoldDelay) {
        super(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice);
        this.unsoldDelay = unsoldDelay;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(unsoldDelay);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        unsoldDelay = buf.readShort();
        if (unsoldDelay < 0)
            throw new RuntimeException("Forbidden value on unsoldDelay = " + unsoldDelay + ", it doesn't respect the following condition : unsoldDelay < 0");
    }
    
}
