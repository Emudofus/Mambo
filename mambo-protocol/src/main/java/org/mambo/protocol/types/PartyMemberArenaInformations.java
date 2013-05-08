

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyMemberArenaInformations extends PartyMemberInformations {
    public static final short TYPE_ID = 391;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short rank;
    
    public PartyMemberArenaInformations() { }
    
    public PartyMemberArenaInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, boolean pvpEnabled, byte alignmentSide, short worldX, short worldY, int mapId, short subAreaId, PlayerStatus status, short rank) {
        super(id, level, name, entityLook, breed, sex, lifePoints, maxLifePoints, prospecting, regenRate, initiative, pvpEnabled, alignmentSide, worldX, worldY, mapId, subAreaId, status);
        this.rank = rank;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(rank);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        rank = buf.readShort();
        if (rank < 0 || rank > 2300)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0 || rank > 2300");
    }
    
}
