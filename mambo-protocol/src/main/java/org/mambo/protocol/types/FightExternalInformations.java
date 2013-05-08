

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightExternalInformations extends NetworkType {
    public static final short TYPE_ID = 117;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int fightId;
    public byte fightType;
    public int fightStart;
    public boolean fightSpectatorLocked;
    public FightTeamLightInformations[] fightTeams;
    public FightOptionsInformations[] fightTeamsOptions;
    
    public FightExternalInformations() { }
    
    public FightExternalInformations(int fightId, byte fightType, int fightStart, boolean fightSpectatorLocked, FightTeamLightInformations[] fightTeams, FightOptionsInformations[] fightTeamsOptions) {
        this.fightId = fightId;
        this.fightType = fightType;
        this.fightStart = fightStart;
        this.fightSpectatorLocked = fightSpectatorLocked;
        this.fightTeams = fightTeams;
        this.fightTeamsOptions = fightTeamsOptions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeByte(fightType);
        buf.writeInt(fightStart);
        buf.writeBoolean(fightSpectatorLocked);
        for (FightTeamLightInformations entry : fightTeams) {
            entry.serialize(buf);
        }
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
        fightStart = buf.readInt();
        if (fightStart < 0)
            throw new RuntimeException("Forbidden value on fightStart = " + fightStart + ", it doesn't respect the following condition : fightStart < 0");
        fightSpectatorLocked = buf.readBoolean();
        fightTeams = new FightTeamLightInformations[2];
        for (int i = 0; i < 2; i++) {
            fightTeams[i] = new FightTeamLightInformations();
            fightTeams[i].deserialize(buf);
        }
        fightTeamsOptions = new FightOptionsInformations[2];
        for (int i = 0; i < 2; i++) {
            fightTeamsOptions[i] = new FightOptionsInformations();
            fightTeamsOptions[i].deserialize(buf);
        }
    }
    
}
