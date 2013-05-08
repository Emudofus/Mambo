

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public PlayerStatus status;
    
    public PartyMemberInformations() { }
    
    public PartyMemberInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, boolean pvpEnabled, byte alignmentSide, short worldX, short worldY, int mapId, short subAreaId, PlayerStatus status) {
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
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(lifePoints);
        buf.writeInt(maxLifePoints);
        buf.writeShort(prospecting);
        buf.writeUByte(regenRate);
        buf.writeShort(initiative);
        buf.writeBoolean(pvpEnabled);
        buf.writeByte(alignmentSide);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        lifePoints = buf.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = buf.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        prospecting = buf.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        regenRate = buf.readUByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
        initiative = buf.readShort();
        if (initiative < 0)
            throw new RuntimeException("Forbidden value on initiative = " + initiative + ", it doesn't respect the following condition : initiative < 0");
        pvpEnabled = buf.readBoolean();
        alignmentSide = buf.readByte();
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
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
