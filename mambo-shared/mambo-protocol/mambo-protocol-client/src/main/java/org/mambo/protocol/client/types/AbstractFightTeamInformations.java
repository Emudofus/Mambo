

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractFightTeamInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 116;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(teamId);
        writer.writeInt(leaderId);
        writer.writeByte(teamSide);
        writer.writeByte(teamTypeId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        teamId = reader.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        leaderId = reader.readInt();
        teamSide = reader.readByte();
        teamTypeId = reader.readByte();
        if (teamTypeId < 0)
            throw new RuntimeException("Forbidden value on teamTypeId = " + teamTypeId + ", it doesn't respect the following condition : teamTypeId < 0");
    }
    
}
