

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayArenaUpdatePlayerInfosMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6301;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short rank;
    public short bestDailyRank;
    public short bestRank;
    public short victoryCount;
    public short arenaFightcount;
    
    public GameRolePlayArenaUpdatePlayerInfosMessage() { }
    
    public GameRolePlayArenaUpdatePlayerInfosMessage(short rank, short bestDailyRank, short bestRank, short victoryCount, short arenaFightcount) {
        this.rank = rank;
        this.bestDailyRank = bestDailyRank;
        this.bestRank = bestRank;
        this.victoryCount = victoryCount;
        this.arenaFightcount = arenaFightcount;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(rank);
        writer.writeShort(bestDailyRank);
        writer.writeShort(bestRank);
        writer.writeShort(victoryCount);
        writer.writeShort(arenaFightcount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        rank = reader.readShort();
        if (rank < 0 || rank > 2300)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0 || rank > 2300");
        bestDailyRank = reader.readShort();
        if (bestDailyRank < 0 || bestDailyRank > 2300)
            throw new RuntimeException("Forbidden value on bestDailyRank = " + bestDailyRank + ", it doesn't respect the following condition : bestDailyRank < 0 || bestDailyRank > 2300");
        bestRank = reader.readShort();
        if (bestRank < 0 || bestRank > 2300)
            throw new RuntimeException("Forbidden value on bestRank = " + bestRank + ", it doesn't respect the following condition : bestRank < 0 || bestRank > 2300");
        victoryCount = reader.readShort();
        if (victoryCount < 0)
            throw new RuntimeException("Forbidden value on victoryCount = " + victoryCount + ", it doesn't respect the following condition : victoryCount < 0");
        arenaFightcount = reader.readShort();
        if (arenaFightcount < 0)
            throw new RuntimeException("Forbidden value on arenaFightcount = " + arenaFightcount + ", it doesn't respect the following condition : arenaFightcount < 0");
    }
    
}
