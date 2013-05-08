

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HumanOptionOrnament extends HumanOption {
    public static final short TYPE_ID = 411;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short ornamentId;
    
    public HumanOptionOrnament() { }
    
    public HumanOptionOrnament(short ornamentId) {
        this.ornamentId = ornamentId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(ornamentId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        ornamentId = buf.readShort();
        if (ornamentId < 0)
            throw new RuntimeException("Forbidden value on ornamentId = " + ornamentId + ", it doesn't respect the following condition : ornamentId < 0");
    }
    
}
