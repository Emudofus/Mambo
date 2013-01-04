

// Generated on 01/04/2013 14:54:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildFightPlayersHelpersJoinMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5720;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public CharacterMinimalPlusLookInformations playerInfo;
    
    public GuildFightPlayersHelpersJoinMessage() { }
    
    public GuildFightPlayersHelpersJoinMessage(double fightId, CharacterMinimalPlusLookInformations playerInfo) {
        this.fightId = fightId;
        this.playerInfo = playerInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        playerInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        playerInfo = new CharacterMinimalPlusLookInformations();
        playerInfo.deserialize(reader);
    }
    
}
