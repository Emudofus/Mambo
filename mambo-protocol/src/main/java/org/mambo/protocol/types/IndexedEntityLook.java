

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IndexedEntityLook extends NetworkType {
    public static final short TYPE_ID = 405;
    
    @Override
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
    public void serialize(Buffer buf) {
        look.serialize(buf);
        buf.writeByte(index);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        look = new EntityLook();
        look.deserialize(buf);
        index = buf.readByte();
        if (index < 0)
            throw new RuntimeException("Forbidden value on index = " + index + ", it doesn't respect the following condition : index < 0");
    }
    
}
