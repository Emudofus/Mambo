

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(mapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        mapId = reader.readInt();
    }
    
}
