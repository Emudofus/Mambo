

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeUnsignedShort(players.length);
        for (DungeonPartyFinderPlayer entry : players) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = reader.readUnsignedShort();
        players = new DungeonPartyFinderPlayer[limit];
        for (int i = 0; i < limit; i++) {
            players[i] = new DungeonPartyFinderPlayer();
            players[i].deserialize(reader);
        }
    }
    
}
