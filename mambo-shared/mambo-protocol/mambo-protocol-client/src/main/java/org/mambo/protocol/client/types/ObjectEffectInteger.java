

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class ObjectEffectInteger extends ObjectEffect {
    public static final short TYPE_ID = 70;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short value;
    
    public ObjectEffectInteger() { }
    
    public ObjectEffectInteger(short actionId, short value) {
        super(actionId);
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        value = reader.readShort();
        if (value < 0)
            throw new RuntimeException("Forbidden value on value = " + value + ", it doesn't respect the following condition : value < 0");
    }
    
}
