

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightLoot implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 41;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short[] objects;
    public int kamas;
    
    public FightLoot() { }
    
    public FightLoot(short[] objects, int kamas) {
        this.objects = objects;
        this.kamas = kamas;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(objects.length);
        for (short entry : objects) {
            writer.writeShort(entry);
        }
        writer.writeInt(kamas);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        objects = new short[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = reader.readShort();
        }
        kamas = reader.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
    }
    
}
