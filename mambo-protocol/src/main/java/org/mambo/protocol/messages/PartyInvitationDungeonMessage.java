

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyInvitationDungeonMessage extends PartyInvitationMessage {
    public static final int MESSAGE_ID = 6244;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    
    public PartyInvitationDungeonMessage() { }
    
    public PartyInvitationDungeonMessage(int partyId, byte partyType, byte maxParticipants, int fromId, String fromName, int toId, short dungeonId) {
        super(partyId, partyType, maxParticipants, fromId, fromName, toId);
        this.dungeonId = dungeonId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(dungeonId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
