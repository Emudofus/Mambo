

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendSpouseOnlineInformations extends FriendSpouseInformations {
    public static final short TYPE_ID = 93;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean inFight;
    public boolean followSpouse;
    public boolean pvpEnabled;
    public int mapId;
    public short subAreaId;
    
    public FriendSpouseOnlineInformations() { }
    
    public FriendSpouseOnlineInformations(int spouseAccountId, int spouseId, String spouseName, short spouseLevel, byte breed, byte sex, EntityLook spouseEntityLook, BasicGuildInformations guildInfo, byte alignmentSide, boolean inFight, boolean followSpouse, boolean pvpEnabled, int mapId, short subAreaId) {
        super(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide);
        this.inFight = inFight;
        this.followSpouse = followSpouse;
        this.pvpEnabled = pvpEnabled;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, inFight);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, followSpouse);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, pvpEnabled);
        writer.writeUnsignedByte(flag1);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        short flag1 = reader.readUnsignedByte();
        inFight = BooleanByteWrapper.getFlag(flag1, 0);
        followSpouse = BooleanByteWrapper.getFlag(flag1, 1);
        pvpEnabled = BooleanByteWrapper.getFlag(flag1, 2);
        mapId = reader.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
