

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightCommonInformations extends NetworkType {
    public static final short TYPE_ID = 43;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int fightId;
    public byte fightType;
    public FightTeamInformations[] fightTeams;
    public short[] fightTeamsPositions;
    public FightOptionsInformations[] fightTeamsOptions;
    
    public FightCommonInformations() { }
    
    public FightCommonInformations(int fightId, byte fightType, FightTeamInformations[] fightTeams, short[] fightTeamsPositions, FightOptionsInformations[] fightTeamsOptions) {
        this.fightId = fightId;
        this.fightType = fightType;
        this.fightTeams = fightTeams;
        this.fightTeamsPositions = fightTeamsPositions;
        this.fightTeamsOptions = fightTeamsOptions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeByte(fightType);
        buf.writeUShort(fightTeams.length);
        for (FightTeamInformations entry : fightTeams) {
            entry.serialize(buf);
        }
        buf.writeUShort(fightTeamsPositions.length);
        for (short entry : fightTeamsPositions) {
            buf.writeShort(entry);
        }
        buf.writeUShort(fightTeamsOptions.length);
        for (FightOptionsInformations entry : fightTeamsOptions) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        fightType = buf.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
        int limit = buf.readUShort();
        fightTeams = new FightTeamInformations[limit];
        for (int i = 0; i < limit; i++) {
            fightTeams[i] = new FightTeamInformations();
            fightTeams[i].deserialize(buf);
        }
        limit = buf.readUShort();
        fightTeamsPositions = new short[limit];
        for (int i = 0; i < limit; i++) {
            fightTeamsPositions[i] = buf.readShort();
        }
        limit = buf.readUShort();
        fightTeamsOptions = new FightOptionsInformations[limit];
        for (int i = 0; i < limit; i++) {
            fightTeamsOptions[i] = new FightOptionsInformations();
            fightTeamsOptions[i].deserialize(buf);
        }
    }
    
}
