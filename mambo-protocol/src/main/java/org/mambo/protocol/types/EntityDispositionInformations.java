

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EntityDispositionInformations extends NetworkType {
    public static final short TYPE_ID = 60;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short cellId;
    public byte direction;
    
    public EntityDispositionInformations() { }
    
    public EntityDispositionInformations(short cellId, byte direction) {
        this.cellId = cellId;
        this.direction = direction;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(cellId);
        buf.writeByte(direction);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cellId = buf.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
        direction = buf.readByte();
        if (direction < 0)
            throw new RuntimeException("Forbidden value on direction = " + direction + ", it doesn't respect the following condition : direction < 0");
    }
    
}
