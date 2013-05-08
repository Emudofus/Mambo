

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockAbandonnedInformations extends PaddockBuyableInformations {
    public static final short TYPE_ID = 133;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guildId;
    
    public PaddockAbandonnedInformations() { }
    
    public PaddockAbandonnedInformations(short maxOutdoorMount, short maxItems, int price, boolean locked, int guildId) {
        super(maxOutdoorMount, maxItems, price, locked);
        this.guildId = guildId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(guildId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guildId = buf.readInt();
    }
    
}
