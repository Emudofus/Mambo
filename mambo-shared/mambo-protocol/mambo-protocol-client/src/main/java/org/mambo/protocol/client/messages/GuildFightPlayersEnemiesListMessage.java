

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeUnsignedShort(playerInfo.length);
        for (CharacterMinimalPlusLookInformations entry : playerInfo) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = reader.readUnsignedShort();
        playerInfo = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            playerInfo[i] = new CharacterMinimalPlusLookInformations();
            playerInfo[i].deserialize(reader);
        }
    }
    
}
