

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderRoomContentMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6247;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public DungeonPartyFinderPlayer[] players;
    
    public DungeonPartyFinderRoomContentMessage() { }
    
    public DungeonPartyFinderRoomContentMessage(short dungeonId, DungeonPartyFinderPlayer[] players) {
        this.dungeonId = dungeonId;
        this.players = players;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
        buf.writeUShort(players.length);
        for (DungeonPartyFinderPlayer entry : players) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = buf.readUShort();
        players = new DungeonPartyFinderPlayer[limit];
        for (int i = 0; i < limit; i++) {
            players[i] = new DungeonPartyFinderPlayer();
            players[i].deserialize(buf);
        }
    }
    
}
