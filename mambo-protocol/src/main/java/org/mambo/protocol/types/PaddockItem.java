

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockItem extends ObjectItemInRolePlay {
    public static final short TYPE_ID = 185;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ItemDurability durability;
    
    public PaddockItem() { }
    
    public PaddockItem(short cellId, short objectGID, ItemDurability durability) {
        super(cellId, objectGID);
        this.durability = durability;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        durability.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        durability = new ItemDurability();
        durability.deserialize(buf);
    }
    
}
