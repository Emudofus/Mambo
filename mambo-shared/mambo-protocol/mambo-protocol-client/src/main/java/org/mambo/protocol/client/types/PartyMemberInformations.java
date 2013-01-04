

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyMemberInformations extends CharacterBaseInformations {
    public static final short TYPE_ID = 90;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int lifePoints;
    public int maxLifePoints;
    public short prospecting;
    public short regenRate;
    public short initiative;
    public boolean pvpEnabled;
    public byte alignmentSide;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    
    public PartyMemberInformations() { }
    
    public PartyMemberInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, boolean pvpEnabled, byte alignmentSide, short worldX, short worldY, int mapId, short subAreaId) {
        super(id, level, name, entityLook, breed, sex);
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.prospecting = prospecting;
        this.regenRate = regenRate;
        this.initiative = initiative;
        this.pvpEnabled = pvpEnabled;
        this.alignmentSide = alignmentSide;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
        writer.writeShort(prospecting);
        writer.writeUnsignedByte(regenRate);
        writer.writeShort(initiative);
        writer.writeBoolean(pvpEnabled);
        writer.writeByte(alignmentSide);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        lifePoints = reader.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = reader.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        prospecting = reader.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        regenRate = reader.readUnsignedByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
        initiative = reader.readShort();
        if (initiative < 0)
            throw new RuntimeException("Forbidden value on initiative = " + initiative + ", it doesn't respect the following condition : initiative < 0");
        pvpEnabled = reader.readBoolean();
        alignmentSide = reader.readByte();
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
