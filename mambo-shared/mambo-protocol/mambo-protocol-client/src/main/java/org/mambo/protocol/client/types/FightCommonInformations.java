

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightCommonInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 43;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeByte(fightType);
        writer.writeUnsignedShort(fightTeams.length);
        for (FightTeamInformations entry : fightTeams) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(fightTeamsPositions.length);
        for (short entry : fightTeamsPositions) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(fightTeamsOptions.length);
        for (FightOptionsInformations entry : fightTeamsOptions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        fightType = reader.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
        int limit = reader.readUnsignedShort();
        fightTeams = new FightTeamInformations[limit];
        for (int i = 0; i < limit; i++) {
            fightTeams[i] = new FightTeamInformations();
            fightTeams[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        fightTeamsPositions = new short[limit];
        for (int i = 0; i < limit; i++) {
            fightTeamsPositions[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        fightTeamsOptions = new FightOptionsInformations[limit];
        for (int i = 0; i < limit; i++) {
            fightTeamsOptions[i] = new FightOptionsInformations();
            fightTeamsOptions[i].deserialize(reader);
        }
    }
    
}
