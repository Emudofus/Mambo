

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightTeamInformations extends AbstractFightTeamInformations {
    public static final short TYPE_ID = 33;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public FightTeamMemberInformations[] teamMembers;
    
    public FightTeamInformations() { }
    
    public FightTeamInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, FightTeamMemberInformations[] teamMembers) {
        super(teamId, leaderId, teamSide, teamTypeId);
        this.teamMembers = teamMembers;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(teamMembers.length);
        for (FightTeamMemberInformations entry : teamMembers) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        teamMembers = new FightTeamMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            teamMembers[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), FightTeamMemberInformations.class);
            teamMembers[i].deserialize(reader);
        }
    }
    
}
