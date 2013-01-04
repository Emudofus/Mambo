

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class IndexedEntityLook implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 405;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public EntityLook look;
    public byte index;
    
    public IndexedEntityLook() { }
    
    public IndexedEntityLook(EntityLook look, byte index) {
        this.look = look;
        this.index = index;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        look.serialize(writer);
        writer.writeByte(index);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        look = new EntityLook();
        look.deserialize(reader);
        index = reader.readByte();
        if (index < 0)
            throw new RuntimeException("Forbidden value on index = " + index + ", it doesn't respect the following condition : index < 0");
    }
    
}
