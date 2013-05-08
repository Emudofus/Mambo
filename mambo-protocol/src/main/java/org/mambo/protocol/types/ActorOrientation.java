

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ActorOrientation extends NetworkType {
    public static final short TYPE_ID = 353;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public byte direction;
    
    public ActorOrientation() { }
    
    public ActorOrientation(int id, byte direction) {
        this.id = id;
        this.direction = direction;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        buf.writeByte(direction);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        direction = buf.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
