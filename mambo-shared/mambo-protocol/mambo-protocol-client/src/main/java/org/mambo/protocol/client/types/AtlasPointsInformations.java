

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AtlasPointsInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 175;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(type);
        writer.writeUnsignedShort(coords.length);
        for (MapCoordinatesExtended entry : coords) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readByte();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        int limit = reader.readUnsignedShort();
        coords = new MapCoordinatesExtended[limit];
        for (int i = 0; i < limit; i++) {
            coords[i] = new MapCoordinatesExtended();
            coords[i].deserialize(reader);
        }
    }
    
}
