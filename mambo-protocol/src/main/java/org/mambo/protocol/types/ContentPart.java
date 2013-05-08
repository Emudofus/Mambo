

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ContentPart extends NetworkType {
    public static final short TYPE_ID = 350;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String id;
    public byte state;
    
    public ContentPart() { }
    
    public ContentPart(String id, byte state) {
        this.id = id;
        this.state = state;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(id);
        buf.writeByte(state);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readString();
        state = buf.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
