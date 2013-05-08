

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SubEntity extends NetworkType {
    public static final short TYPE_ID = 54;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte bindingPointCategory;
    public byte bindingPointIndex;
    public EntityLook subEntityLook;
    
    public SubEntity() { }
    
    public SubEntity(byte bindingPointCategory, byte bindingPointIndex, EntityLook subEntityLook) {
        this.bindingPointCategory = bindingPointCategory;
        this.bindingPointIndex = bindingPointIndex;
        this.subEntityLook = subEntityLook;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(bindingPointCategory);
        buf.writeByte(bindingPointIndex);
        subEntityLook.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        bindingPointCategory = buf.readByte();
        if (bindingPointCategory < 0)
            throw new RuntimeException("Forbidden value on bindingPointCategory = " + bindingPointCategory + ", it doesn't respect the following condition : bindingPointCategory < 0");
        bindingPointIndex = buf.readByte();
        if (bindingPointIndex < 0)
            throw new RuntimeException("Forbidden value on bindingPointIndex = " + bindingPointIndex + ", it doesn't respect the following condition : bindingPointIndex < 0");
        subEntityLook = new EntityLook();
        subEntityLook.deserialize(buf);
    }
    
}
