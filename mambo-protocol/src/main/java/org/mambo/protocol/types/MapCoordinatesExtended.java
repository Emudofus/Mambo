

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapCoordinatesExtended extends MapCoordinatesAndId {
    public static final short TYPE_ID = 176;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short subAreaId;
    
    public MapCoordinatesExtended() { }
    
    public MapCoordinatesExtended(short worldX, short worldY, int mapId, short subAreaId) {
        super(worldX, worldY, mapId);
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
