

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AtlasPointsInformations extends NetworkType {
    public static final short TYPE_ID = 175;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte type;
    public MapCoordinatesExtended[] coords;
    
    public AtlasPointsInformations() { }
    
    public AtlasPointsInformations(byte type, MapCoordinatesExtended[] coords) {
        this.type = type;
        this.coords = coords;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(type);
        buf.writeUShort(coords.length);
        for (MapCoordinatesExtended entry : coords) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = buf.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        int limit = buf.readUShort();
        coords = new MapCoordinatesExtended[limit];
        for (int i = 0; i < limit; i++) {
            coords[i] = new MapCoordinatesExtended();
            coords[i].deserialize(buf);
        }
    }
    
}
