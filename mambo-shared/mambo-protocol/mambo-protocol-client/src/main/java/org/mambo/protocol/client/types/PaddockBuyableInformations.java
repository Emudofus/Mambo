

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(price);
        writer.writeBoolean(locked);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        price = reader.readInt();
        if (price < 0)
            throw new RuntimeException("Forbidden value on price = " + price + ", it doesn't respect the following condition : price < 0");
        locked = reader.readBoolean();
    }
    
}
