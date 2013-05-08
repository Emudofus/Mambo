

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTeamLightInformations extends AbstractFightTeamInformations {
    public static final short TYPE_ID = 115;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean hasFriend;
    public boolean hasGuildMember;
    public boolean hasGroupMember;
    public boolean hasMyTaxCollector;
    public byte teamMembersCount;
    public int meanLevel;
    
    public FightTeamLightInformations() { }
    
    public FightTeamLightInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, boolean hasFriend, boolean hasGuildMember, boolean hasGroupMember, boolean hasMyTaxCollector, byte teamMembersCount, int meanLevel) {
        super(teamId, leaderId, teamSide, teamTypeId);
        this.hasFriend = hasFriend;
        this.hasGuildMember = hasGuildMember;
        this.hasGroupMember = hasGroupMember;
        this.hasMyTaxCollector = hasMyTaxCollector;
        this.teamMembersCount = teamMembersCount;
        this.meanLevel = meanLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, hasFriend);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, hasGuildMember);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, hasGroupMember);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, hasMyTaxCollector);
        buf.writeUByte(flag1);
        buf.writeByte(teamMembersCount);
        buf.writeInt(meanLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        short flag1 = buf.readUByte();
        hasFriend = BooleanByteWrapper.getFlag(flag1, 0);
        hasGuildMember = BooleanByteWrapper.getFlag(flag1, 1);
        hasGroupMember = BooleanByteWrapper.getFlag(flag1, 2);
        hasMyTaxCollector = BooleanByteWrapper.getFlag(flag1, 3);
        teamMembersCount = buf.readByte();
        if (teamMembersCount < 0)
            throw new RuntimeException("Forbidden value on teamMembersCount = " + teamMembersCount + ", it doesn't respect the following condition : teamMembersCount < 0");
        meanLevel = buf.readInt();
        if (meanLevel < 0)
            throw new RuntimeException("Forbidden value on meanLevel = " + meanLevel + ", it doesn't respect the following condition : meanLevel < 0");
    }
    
}
