

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(min);
        buf.writeShort(max);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        min = buf.readShort();
        if (min < 0)
            throw new RuntimeException("Forbidden value on min = " + min + ", it doesn't respect the following condition : min < 0");
        max = buf.readShort();
        if (max < 0)
            throw new RuntimeException("Forbidden value on max = " + max + ", it doesn't respect the following condition : max < 0");
    }
    
}
