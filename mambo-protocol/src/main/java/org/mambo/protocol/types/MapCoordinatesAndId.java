

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapCoordinatesAndId extends MapCoordinates {
    public static final short TYPE_ID = 392;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int mapId;
    
    public MapCoordinatesAndId() { }
    
    public MapCoordinatesAndId(short worldX, short worldY, int mapId) {
        super(worldX, worldY);
        this.mapId = mapId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(mapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        mapId = buf.readInt();
    }
    
}
