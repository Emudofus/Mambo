

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(fightId);
        team.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readShort();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        team = new FightTeamInformations();
        team.deserialize(buf);
    }
    
}
