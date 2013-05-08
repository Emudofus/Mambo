

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismSubAreaInformation extends NetworkType {
    public static final short TYPE_ID = 142;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public byte alignment;
    public boolean isInFight;
    public boolean isFightable;
    
    public PrismSubAreaInformation() { }
    
    public PrismSubAreaInformation(short worldX, short worldY, int mapId, short subAreaId, byte alignment, boolean isInFight, boolean isFightable) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.alignment = alignment;
        this.isInFight = isInFight;
        this.isFightable = isFightable;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeByte(alignment);
        buf.writeBoolean(isInFight);
        buf.writeBoolean(isFightable);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = buf.readInt();
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        alignment = buf.readByte();
        if (alignment < 0)
            throw new RuntimeException("Forbidden value on alignment = " + alignment + ", it doesn't respect the following condition : alignment < 0");
        isInFight = buf.readBoolean();
        isFightable = buf.readBoolean();
    }
    
}
