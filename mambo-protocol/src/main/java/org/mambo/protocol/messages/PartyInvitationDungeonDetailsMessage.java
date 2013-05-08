

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage {
    public static final int MESSAGE_ID = 6262;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public boolean[] playersDungeonReady;
    
    public PartyInvitationDungeonDetailsMessage() { }
    
    public PartyInvitationDungeonDetailsMessage(int partyId, byte partyType, int fromId, String fromName, int leaderId, PartyInvitationMemberInformations[] members, PartyGuestInformations[] guests, short dungeonId, boolean[] playersDungeonReady) {
        super(partyId, partyType, fromId, fromName, leaderId, members, guests);
        this.dungeonId = dungeonId;
        this.playersDungeonReady = playersDungeonReady;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(dungeonId);
        buf.writeUShort(playersDungeonReady.length);
        for (boolean entry : playersDungeonReady) {
            buf.writeBoolean(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        int limit = buf.readUShort();
        playersDungeonReady = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            playersDungeonReady[i] = buf.readBoolean();
        }
    }
    
}
