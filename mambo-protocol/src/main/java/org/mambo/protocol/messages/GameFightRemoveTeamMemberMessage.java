

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(fightId);
        buf.writeByte(teamId);
        buf.writeInt(charId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readShort();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        teamId = buf.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        charId = buf.readInt();
    }
    
}
