

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockBuyableInformations extends PaddockInformations {
    public static final short TYPE_ID = 130;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int price;
    public boolean locked;
    
    public PaddockBuyableInformations() { }
    
    public PaddockBuyableInformations(short maxOutdoorMount, short maxItems, int price, boolean locked) {
        super(maxOutdoorMount, maxItems);
        this.price = price;
        this.locked = locked;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(price);
        buf.writeBoolean(locked);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        price = buf.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
        locked = buf.readBoolean();
    }
    
}
