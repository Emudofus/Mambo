

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class UpdateMountIntBoost extends UpdateMountBoost {
    public static final short TYPE_ID = 357;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int value;
    
    public UpdateMountIntBoost() { }
    
    public UpdateMountIntBoost(byte type, int value) {
        super(type);
        this.value = value;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(value);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        value = buf.readInt();
    }
    
}
