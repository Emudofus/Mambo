

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class FightTeamLightInformations extends AbstractFightTeamInformations {
    public static final short TYPE_ID = 115;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte teamMembersCount;
    
    public FightTeamLightInformations() { }
    
    public FightTeamLightInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, byte teamMembersCount) {
        super(teamId, leaderId, teamSide, teamTypeId);
        this.teamMembersCount = teamMembersCount;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(teamMembersCount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        teamMembersCount = reader.readByte();
        if (teamMembersCount < 0)
            throw new RuntimeException("Forbidden value on teamMembersCount = " + teamMembersCount + ", it doesn't respect the following condition : teamMembersCount < 0");
    }
    
}
