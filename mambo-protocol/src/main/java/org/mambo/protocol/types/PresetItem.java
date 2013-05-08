

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PresetItem extends NetworkType {
    public static final short TYPE_ID = 354;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short position;
    public int objGid;
    public int objUid;
    
    public PresetItem() { }
    
    public PresetItem(short position, int objGid, int objUid) {
        this.position = position;
        this.objGid = objGid;
        this.objUid = objUid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUByte(position);
        buf.writeInt(objGid);
        buf.writeInt(objUid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        position = buf.readUByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        objGid = buf.readInt();
        if (objGid < 0)
            throw new RuntimeException("Forbidden value on objGid = " + objGid + ", it doesn't respect the following condition : objGid < 0");
        objUid = buf.readInt();
        if (objUid < 0)
            throw new RuntimeException("Forbidden value on objUid = " + objUid + ", it doesn't respect the following condition : objUid < 0");
    }
    
}
