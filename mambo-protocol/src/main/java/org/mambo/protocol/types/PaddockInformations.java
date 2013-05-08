

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockInformations extends NetworkType {
    public static final short TYPE_ID = 132;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short maxOutdoorMount;
    public short maxItems;
    
    public PaddockInformations() { }
    
    public PaddockInformations(short maxOutdoorMount, short maxItems) {
        this.maxOutdoorMount = maxOutdoorMount;
        this.maxItems = maxItems;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(maxOutdoorMount);
        buf.writeShort(maxItems);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        maxOutdoorMount = buf.readShort();
        if (maxOutdoorMount < 0)
            throw new RuntimeException("Forbidden value on maxOutdoorMount = " + maxOutdoorMount + ", it doesn't respect the following condition : maxOutdoorMount < 0");
        maxItems = buf.readShort();
        if (maxItems < 0)
            throw new RuntimeException("Forbidden value on maxItems = " + maxItems + ", it doesn't respect the following condition : maxItems < 0");
    }
    
}
