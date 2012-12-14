

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightRemoveTeamMemberMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 711;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short fightId;
    public byte teamId;
    public int charId;
    
    public GameFightRemoveTeamMemberMessage() { }
    
    public GameFightRemoveTeamMemberMessage(short fightId, byte teamId, int charId) {
        this.fightId = fightId;
        this.teamId = teamId;
        this.charId = charId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(fightId);
        writer.writeByte(teamId);
        writer.writeInt(charId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readShort();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        teamId = reader.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        charId = reader.readInt();
    }
    
}
