

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildFightPlayersEnemiesListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5928;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public CharacterMinimalPlusLookInformations[] playerInfo;
    
    public GuildFightPlayersEnemiesListMessage() { }
    
    public GuildFightPlayersEnemiesListMessage(double fightId, CharacterMinimalPlusLookInformations[] playerInfo) {
        this.fightId = fightId;
        this.playerInfo = playerInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeUShort(playerInfo.length);
        for (CharacterMinimalPlusLookInformations entry : playerInfo) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = buf.readUShort();
        playerInfo = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            playerInfo[i] = new CharacterMinimalPlusLookInformations();
            playerInfo[i].deserialize(buf);
        }
    }
    
}
