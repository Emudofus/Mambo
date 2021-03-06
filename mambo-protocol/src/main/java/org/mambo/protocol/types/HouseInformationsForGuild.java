

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseInformationsForGuild extends NetworkType {
    public static final short TYPE_ID = 170;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(houseId);
        buf.writeInt(modelId);
        buf.writeString(ownerName);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeUShort(skillListIds.length);
        for (int entry : skillListIds) {
            buf.writeInt(entry);
        }
        buf.writeUInt(guildshareParams);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        houseId = buf.readInt();
        if (houseId < 0)
            throw new RuntimeException("Forbidden value on houseId = " + houseId + ", it doesn't respect the following condition : houseId < 0");
        modelId = buf.readInt();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
        ownerName = buf.readString();
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
        int limit = buf.readUShort();
        skillListIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            skillListIds[i] = buf.readInt();
        }
        guildshareParams = buf.readUInt();
        if (guildshareParams < 0 || guildshareParams > 4294967295L)
            throw new RuntimeException("Forbidden value on guildshareParams = " + guildshareParams + ", it doesn't respect the following condition : guildshareParams < 0 || guildshareParams > 4294967295L");
    }
    
}
