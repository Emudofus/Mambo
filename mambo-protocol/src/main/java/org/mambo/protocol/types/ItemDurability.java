

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ItemDurability extends NetworkType {
    public static final short TYPE_ID = 168;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short durability;
    public short durabilityMax;
    
    public ItemDurability() { }
    
    public ItemDurability(short durability, short durabilityMax) {
        this.durability = durability;
        this.durabilityMax = durabilityMax;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(durability);
        buf.writeShort(durabilityMax);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        durability = buf.readShort();
        durabilityMax = buf.readShort();
    }
    
}
