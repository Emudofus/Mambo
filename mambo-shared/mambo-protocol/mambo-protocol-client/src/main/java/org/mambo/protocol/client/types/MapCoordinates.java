

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MapCoordinates implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 174;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short worldX;
    public short worldY;
    
    public MapCoordinates() { }
    
    public MapCoordinates(short worldX, short worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(worldX);
        writer.writeShort(worldY);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
    }
    
}
