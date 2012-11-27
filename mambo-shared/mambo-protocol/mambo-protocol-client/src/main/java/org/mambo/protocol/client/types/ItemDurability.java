

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ItemDurability implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 168;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(durability);
        writer.writeShort(durabilityMax);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        durability = reader.readShort();
        durabilityMax = reader.readShort();
    }
    
}
