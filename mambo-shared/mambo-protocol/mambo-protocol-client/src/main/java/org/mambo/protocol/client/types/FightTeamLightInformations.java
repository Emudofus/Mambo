

// Generated on 01/04/2013 14:54:45
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
