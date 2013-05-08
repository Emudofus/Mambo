

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(rank);
        buf.writeShort(bestDailyRank);
        buf.writeShort(bestRank);
        buf.writeShort(victoryCount);
        buf.writeShort(arenaFightcount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        rank = buf.readShort();
        if (rank < 0 || rank > 2300)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0 || rank > 2300");
        bestDailyRank = buf.readShort();
        if (bestDailyRank < 0 || bestDailyRank > 2300)
            throw new RuntimeException("Forbidden value on bestDailyRank = " + bestDailyRank + ", it doesn't respect the following condition : bestDailyRank < 0 || bestDailyRank > 2300");
        bestRank = buf.readShort();
        if (bestRank < 0 || bestRank > 2300)
            throw new RuntimeException("Forbidden value on bestRank = " + bestRank + ", it doesn't respect the following condition : bestRank < 0 || bestRank > 2300");
        victoryCount = buf.readShort();
        if (victoryCount < 0)
            throw new RuntimeException("Forbidden value on victoryCount = " + victoryCount + ", it doesn't respect the following condition : victoryCount < 0");
        arenaFightcount = buf.readShort();
        if (arenaFightcount < 0)
            throw new RuntimeException("Forbidden value on arenaFightcount = " + arenaFightcount + ", it doesn't respect the following condition : arenaFightcount < 0");
    }
    
}
