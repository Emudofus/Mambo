

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffectString extends ObjectEffect {
    public static final short TYPE_ID = 74;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String value;
    
    public ObjectEffectString() { }
    
    public ObjectEffectString(short actionId, String value) {
        super(actionId);
        this.value = value;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(value);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        value = buf.readString();
    }
    
}
