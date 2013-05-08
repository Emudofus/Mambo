

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapObstacle extends NetworkType {
    public static final short TYPE_ID = 200;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short obstacleCellId;
    public byte state;
    
    public MapObstacle() { }
    
    public MapObstacle(short obstacleCellId, byte state) {
        this.obstacleCellId = obstacleCellId;
        this.state = state;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(obstacleCellId);
        buf.writeByte(state);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        obstacleCellId = buf.readShort();
        if (obstacleCellId < 0 || obstacleCellId > 559)
            throw new RuntimeException("Forbidden value on obstacleCellId = " + obstacleCellId + ", it doesn't respect the following condition : obstacleCellId < 0 || obstacleCellId > 559");
        state = buf.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
