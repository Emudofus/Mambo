

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryPlayerInfo extends NetworkType {
    public static final short TYPE_ID = 194;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int playerId;
    public String playerName;
    public byte alignmentSide;
    public byte breed;
    public boolean sex;
    public boolean isInWorkshop;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    
    public JobCrafterDirectoryEntryPlayerInfo() { }
    
    public JobCrafterDirectoryEntryPlayerInfo(int playerId, String playerName, byte alignmentSide, byte breed, boolean sex, boolean isInWorkshop, short worldX, short worldY, int mapId, short subAreaId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.alignmentSide = alignmentSide;
        this.breed = breed;
        this.sex = sex;
        this.isInWorkshop = isInWorkshop;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(playerId);
        buf.writeString(playerName);
        buf.writeByte(alignmentSide);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        buf.writeBoolean(isInWorkshop);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = buf.readString();
        alignmentSide = buf.readByte();
        breed = buf.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = buf.readBoolean();
        isInWorkshop = buf.readBoolean();
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
    }
    
}
