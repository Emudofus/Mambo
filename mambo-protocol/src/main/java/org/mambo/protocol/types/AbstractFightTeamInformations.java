

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractFightTeamInformations extends NetworkType {
    public static final short TYPE_ID = 116;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte teamId;
    public int leaderId;
    public byte teamSide;
    public byte teamTypeId;
    
    public AbstractFightTeamInformations() { }
    
    public AbstractFightTeamInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId) {
        this.teamId = teamId;
        this.leaderId = leaderId;
        this.teamSide = teamSide;
        this.teamTypeId = teamTypeId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(teamId);
        buf.writeInt(leaderId);
        buf.writeByte(teamSide);
        buf.writeByte(teamTypeId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        teamId = buf.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        leaderId = buf.readInt();
        teamSide = buf.readByte();
        teamTypeId = buf.readByte();
        if (teamTypeId < 0)
            throw new RuntimeException("Forbidden value on teamTypeId = " + teamTypeId + ", it doesn't respect the following condition : teamTypeId < 0");
    }
    
}
