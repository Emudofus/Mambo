

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightExternalInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 117;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int fightId;
    public int fightStart;
    public boolean fightSpectatorLocked;
    public FightTeamLightInformations[] fightTeams;
    public FightOptionsInformations[] fightTeamsOptions;
    
    public FightExternalInformations() { }
    
    public FightExternalInformations(int fightId, int fightStart, boolean fightSpectatorLocked, FightTeamLightInformations[] fightTeams, FightOptionsInformations[] fightTeamsOptions) {
        this.fightId = fightId;
        this.fightStart = fightStart;
        this.fightSpectatorLocked = fightSpectatorLocked;
        this.fightTeams = fightTeams;
        this.fightTeamsOptions = fightTeamsOptions;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeInt(fightStart);
        writer.writeBoolean(fightSpectatorLocked);
        for (FightTeamLightInformations entry : fightTeams) {
            entry.serialize(writer);
        }
        for (FightOptionsInformations entry : fightTeamsOptions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        fightStart = reader.readInt();
        if (fightStart < 0)
            throw new RuntimeException("Forbidden value on fightStart = " + fightStart + ", it doesn't respect the following condition : fightStart < 0");
        fightSpectatorLocked = reader.readBoolean();
        fightTeams = new FightTeamLightInformations[2];
        for (int i = 0; i < 2; i++) {
            fightTeams[i] = new FightTeamLightInformations();
            fightTeams[i].deserialize(reader);
        }
        fightTeamsOptions = new FightOptionsInformations[2];
        for (int i = 0; i < 2; i++) {
            fightTeamsOptions[i] = new FightOptionsInformations();
            fightTeamsOptions[i].deserialize(reader);
        }
    }
    
}
