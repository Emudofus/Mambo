

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapCoordinates extends NetworkType {
    public static final short TYPE_ID = 174;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(worldX);
        buf.writeShort(worldY);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
    }
    
}
