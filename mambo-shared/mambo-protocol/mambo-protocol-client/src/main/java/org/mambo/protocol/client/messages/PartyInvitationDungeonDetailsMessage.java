

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage {
    public static final int MESSAGE_ID = 6262;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public boolean[] playersDungeonReady;
    
    public PartyInvitationDungeonDetailsMessage() { }
    
    public PartyInvitationDungeonDetailsMessage(int partyId, byte partyType, int fromId, String fromName, int leaderId, PartyInvitationMemberInformations[] members, short dungeonId, boolean[] playersDungeonReady) {
        super(partyId, partyType, fromId, fromName, leaderId, members);
        this.dungeonId = dungeonId;
        this.playersDungeonReady = playersDungeonReady;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(dungeonId);
        writer.writeUnsignedShort(playersDungeonReady.length);
        for (boolean entry : playersDungeonReady) {
            writer.writeBoolean(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = reader.readUnsignedShort();
        playersDungeonReady = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            playersDungeonReady[i] = reader.readBoolean();
        }
    }
    
}
