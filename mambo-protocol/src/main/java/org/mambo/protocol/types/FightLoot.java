

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightLoot extends NetworkType {
    public static final short TYPE_ID = 41;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeUShort(objects.length);
        for (short entry : objects) {
            buf.writeShort(entry);
        }
        buf.writeInt(kamas);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        objects = new short[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = buf.readShort();
        }
        kamas = buf.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
    }
    
}
