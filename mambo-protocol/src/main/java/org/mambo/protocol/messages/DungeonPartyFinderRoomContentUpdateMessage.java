

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderRoomContentUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6250;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public DungeonPartyFinderPlayer[] addedPlayers;
    public int[] removedPlayersIds;
    
    public DungeonPartyFinderRoomContentUpdateMessage() { }
    
    public DungeonPartyFinderRoomContentUpdateMessage(short dungeonId, DungeonPartyFinderPlayer[] addedPlayers, int[] removedPlayersIds) {
        this.dungeonId = dungeonId;
        this.addedPlayers = addedPlayers;
        this.removedPlayersIds = removedPlayersIds;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
        buf.writeUShort(addedPlayers.length);
        for (DungeonPartyFinderPlayer entry : addedPlayers) {
            entry.serialize(buf);
        }
        buf.writeUShort(removedPlayersIds.length);
        for (int entry : removedPlayersIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = buf.readUShort();
        addedPlayers = new DungeonPartyFinderPlayer[limit];
        for (int i = 0; i < limit; i++) {
            addedPlayers[i] = new DungeonPartyFinderPlayer();
            addedPlayers[i].deserialize(buf);
        }
        limit = buf.readUShort();
        removedPlayersIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            removedPlayersIds[i] = buf.readInt();
        }
    }
    
}
