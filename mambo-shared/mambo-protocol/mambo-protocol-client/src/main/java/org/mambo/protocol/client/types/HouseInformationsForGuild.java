

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseInformationsForGuild implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 170;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int houseId;
    public int modelId;
    public String ownerName;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public int[] skillListIds;
    public long guildshareParams;
    
    public HouseInformationsForGuild() { }
    
    public HouseInformationsForGuild(int houseId, int modelId, String ownerName, short worldX, short worldY, int mapId, short subAreaId, int[] skillListIds, long guildshareParams) {
        this.houseId = houseId;
        this.modelId = modelId;
        this.ownerName = ownerName;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.skillListIds = skillListIds;
        this.guildshareParams = guildshareParams;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(houseId);
        writer.writeInt(modelId);
        writer.writeString(ownerName);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
        writer.writeUnsignedShort(skillListIds.length);
        for (int entry : skillListIds) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedInt(guildshareParams);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        houseId = reader.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        modelId = reader.readInt();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerName = reader.readString();
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
        int limit = reader.readUnsignedShort();
        skillListIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            skillListIds[i] = reader.readInt();
        }
        guildshareParams = reader.readUnsignedInt();
        if (guildshareParams < 0 || guildshareParams > 4294967295L)
            throw new RuntimeException("Forbidden value on guildshareParams = " + guildshareParams + ", it doesn't respect the following condition : guildshareParams < 0 || guildshareParams > 4294967295L");
    }
    
}
