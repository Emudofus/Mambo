

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class SubEntity implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 54;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(bindingPointCategory);
        writer.writeByte(bindingPointIndex);
        subEntityLook.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        bindingPointCategory = reader.readByte();
        if (bindingPointCategory < 0)
            throw new RuntimeException("Forbidden value on bindingPointCategory = " + bindingPointCategory + ", it doesn't respect the following condition : bindingPointCategory < 0");
        bindingPointIndex = reader.readByte();
        if (bindingPointIndex < 0)
            throw new RuntimeException("Forbidden value on bindingPointIndex = " + bindingPointIndex + ", it doesn't respect the following condition : bindingPointIndex < 0");
        subEntityLook = new EntityLook();
        subEntityLook.deserialize(reader);
    }
    
}
