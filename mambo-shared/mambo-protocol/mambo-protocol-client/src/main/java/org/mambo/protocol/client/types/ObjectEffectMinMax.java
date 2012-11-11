

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectEffectMinMax extends ObjectEffect {
    public static final short TYPE_ID = 82;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short min;
    public short max;
    
    public ObjectEffectMinMax() { }
    
    public ObjectEffectMinMax(short actionId, short min, short max) {
        super(actionId);
        this.min = min;
        this.max = max;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(min);
        writer.writeShort(max);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        min = reader.readShort();
        if (min < 0)
            throw new RuntimeException("Forbidden value on min = " + min + ", it doesn't respect the following condition : min < 0");
        max = reader.readShort();
        if (max < 0)
            throw new RuntimeException("Forbidden value on max = " + max + ", it doesn't respect the following condition : max < 0");
    }
    
}
