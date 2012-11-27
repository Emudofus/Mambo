

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
