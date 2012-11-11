

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationMemberInformations extends CharacterBaseInformations {
    public static final short TYPE_ID = 376;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    
    public PartyInvitationMemberInformations() { }
    
    public PartyInvitationMemberInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, short worldX, short worldY, int mapId, short subAreaId) {
        super(id, level, name, entityLook, breed, sex);
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
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
