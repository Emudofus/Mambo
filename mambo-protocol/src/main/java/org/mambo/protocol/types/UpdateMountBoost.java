

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class UpdateMountBoost extends NetworkType {
    public static final short TYPE_ID = 356;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte type;
    
    public UpdateMountBoost() { }
    
    public UpdateMountBoost(byte type) {
        this.type = type;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(type);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readByte();
    }
    
}
