

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class Shortcut extends NetworkType {
    public static final short TYPE_ID = 369;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int slot;
    
    public Shortcut() { }
    
    public Shortcut(int slot) {
        this.slot = slot;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(slot);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        slot = buf.readInt();
        if (slot < 0 || slot > 99)
            throw new RuntimeException("Forbidden value on slot = " + slot + ", it doesn't respect the following condition : slot < 0 || slot > 99");
    }
    
}
