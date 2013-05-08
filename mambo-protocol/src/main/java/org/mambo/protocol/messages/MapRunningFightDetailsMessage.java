

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MapRunningFightDetailsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5751;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public GameFightFighterLightInformations[] attackers;
    public GameFightFighterLightInformations[] defenders;
    
    public MapRunningFightDetailsMessage() { }
    
    public MapRunningFightDetailsMessage(int fightId, GameFightFighterLightInformations[] attackers, GameFightFighterLightInformations[] defenders) {
        this.fightId = fightId;
        this.attackers = attackers;
        this.defenders = defenders;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(fightId);
        buf.writeUShort(attackers.length);
        for (GameFightFighterLightInformations entry : attackers) {
            entry.serialize(buf);
        }
        buf.writeUShort(defenders.length);
        for (GameFightFighterLightInformations entry : defenders) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = buf.readUShort();
        attackers = new GameFightFighterLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            attackers[i] = new GameFightFighterLightInformations();
            attackers[i].deserialize(buf);
        }
        limit = buf.readUShort();
        defenders = new GameFightFighterLightInformations[limit];
        for (int i = 0; i < limit; i++) {
            defenders[i] = new GameFightFighterLightInformations();
            defenders[i].deserialize(buf);
        }
    }
    
}
