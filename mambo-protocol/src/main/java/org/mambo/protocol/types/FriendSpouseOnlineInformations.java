

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, inFight);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, followSpouse);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, pvpEnabled);
        buf.writeUByte(flag1);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        short flag1 = buf.readUByte();
        inFight = BooleanByteWrapper.getFlag(flag1, 0);
        followSpouse = BooleanByteWrapper.getFlag(flag1, 1);
        pvpEnabled = BooleanByteWrapper.getFlag(flag1, 2);
        mapId = buf.readInt();
        if (mapId < 0)
            throw new RuntimeException("Forbidden value on mapId = " + mapId + ", it doesn't respect the following condition : mapId < 0");
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
    }
    
}
