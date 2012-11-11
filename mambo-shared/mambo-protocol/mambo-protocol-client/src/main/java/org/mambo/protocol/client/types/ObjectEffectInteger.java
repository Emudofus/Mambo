

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
