

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        durability.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        durability = new ItemDurability();
        durability.deserialize(reader);
    }
    
}
