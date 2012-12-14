

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismSubAreaInformation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 142;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
        writer.writeByte(alignment);
        writer.writeBoolean(isInFight);
        writer.writeBoolean(isFightable);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = reader.readInt();
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        alignment = reader.readByte();
        if (alignment < 0)
            throw new RuntimeException("Forbidden value on alignment = " + alignment + ", it doesn't respect the following condition : alignment < 0");
        isInFight = reader.readBoolean();
        isFightable = reader.readBoolean();
    }
    
}
