

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightUpdateTeamMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5572;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short fightId;
    public FightTeamInformations team;
    
    public GameFightUpdateTeamMessage() { }
    
    public GameFightUpdateTeamMessage(short fightId, FightTeamInformations team) {
        this.fightId = fightId;
        this.team = team;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(fightId);
        team.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readShort();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        team = new FightTeamInformations();
        team.deserialize(reader);
    }
    
}
