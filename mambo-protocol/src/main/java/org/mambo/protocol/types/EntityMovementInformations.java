

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EntityMovementInformations extends NetworkType {
    public static final short TYPE_ID = 63;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public byte[] steps;
    
    public EntityMovementInformations() { }
    
    public EntityMovementInformations(int id, byte[] steps) {
        this.id = id;
        this.steps = steps;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        buf.writeUShort(steps.length);
        for (byte entry : steps) {
            buf.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        int limit = buf.readUShort();
        steps = new byte[limit];
        for (int i = 0; i < limit; i++) {
            steps[i] = buf.readByte();
        }
    }
    
}
