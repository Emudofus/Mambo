

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(teamMembers.length);
        for (FightTeamMemberInformations entry : teamMembers) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        teamMembers = new FightTeamMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            teamMembers[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            teamMembers[i].deserialize(buf);
        }
    }
    
}
