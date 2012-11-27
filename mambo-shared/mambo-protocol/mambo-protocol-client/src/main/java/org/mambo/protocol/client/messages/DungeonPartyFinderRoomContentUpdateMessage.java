

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeUnsignedShort(addedPlayers.length);
        for (DungeonPartyFinderPlayer entry : addedPlayers) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(removedPlayersIds.length);
        for (int entry : removedPlayersIds) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = reader.readUnsignedShort();
        addedPlayers = new DungeonPartyFinderPlayer[limit];
        for (int i = 0; i < limit; i++) {
            addedPlayers[i] = new DungeonPartyFinderPlayer();
            addedPlayers[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        removedPlayersIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            removedPlayersIds[i] = reader.readInt();
        }
    }
    
}
