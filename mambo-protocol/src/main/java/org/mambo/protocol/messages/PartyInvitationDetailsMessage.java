

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyInvitationDetailsMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6263;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte partyType;
    public int fromId;
    public String fromName;
    public int leaderId;
    public PartyInvitationMemberInformations[] members;
    public PartyGuestInformations[] guests;
    
    public PartyInvitationDetailsMessage() { }
    
    public PartyInvitationDetailsMessage(int partyId, byte partyType, int fromId, String fromName, int leaderId, PartyInvitationMemberInformations[] members, PartyGuestInformations[] guests) {
        super(partyId);
        this.partyType = partyType;
        this.fromId = fromId;
        this.fromName = fromName;
        this.leaderId = leaderId;
        this.members = members;
        this.guests = guests;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(partyType);
        buf.writeInt(fromId);
        buf.writeString(fromName);
        buf.writeInt(leaderId);
        buf.writeUShort(members.length);
        for (PartyInvitationMemberInformations entry : members) {
            entry.serialize(buf);
        }
        buf.writeUShort(guests.length);
        for (PartyGuestInformations entry : guests) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        partyType = buf.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        fromId = buf.readInt();
        if (fromId < 0)
            throw new RuntimeException("Forbidden value on fromId = " + fromId + ", it doesn't respect the following condition : fromId < 0");
        fromName = buf.readString();
        leaderId = buf.readInt();
        if (leaderId < 0)
            throw new RuntimeException("Forbidden value on leaderId = " + leaderId + ", it doesn't respect the following condition : leaderId < 0");
        int limit = buf.readUShort();
        members = new PartyInvitationMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = new PartyInvitationMemberInformations();
            members[i].deserialize(buf);
        }
        limit = buf.readUShort();
        guests = new PartyGuestInformations[limit];
        for (int i = 0; i < limit; i++) {
            guests[i] = new PartyGuestInformations();
            guests[i].deserialize(buf);
        }
    }
    
}
