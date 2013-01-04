

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
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
