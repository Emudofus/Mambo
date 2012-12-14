

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryPlayerInfo implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 194;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerId);
        writer.writeString(playerName);
        writer.writeByte(alignmentSide);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        writer.writeBoolean(isInWorkshop);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = reader.readString();
        alignmentSide = reader.readByte();
        breed = reader.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = reader.readBoolean();
        isInWorkshop = reader.readBoolean();
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
    }
    
}
