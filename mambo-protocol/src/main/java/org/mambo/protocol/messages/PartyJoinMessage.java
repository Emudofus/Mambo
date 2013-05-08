

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyJoinMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5576;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte partyType;
    public int partyLeaderId;
    public byte maxParticipants;
    public PartyMemberInformations[] members;
    public PartyGuestInformations[] guests;
    public boolean restricted;
    
    public PartyJoinMessage() { }
    
    public PartyJoinMessage(int partyId, byte partyType, int partyLeaderId, byte maxParticipants, PartyMemberInformations[] members, PartyGuestInformations[] guests, boolean restricted) {
        super(partyId);
        this.partyType = partyType;
        this.partyLeaderId = partyLeaderId;
        this.maxParticipants = maxParticipants;
        this.members = members;
        this.guests = guests;
        this.restricted = restricted;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(partyType);
        buf.writeInt(partyLeaderId);
        buf.writeByte(maxParticipants);
        buf.writeUShort(members.length);
        for (PartyMemberInformations entry : members) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(guests.length);
        for (PartyGuestInformations entry : guests) {
            entry.serialize(buf);
        }
        buf.writeBoolean(restricted);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        partyType = buf.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        partyLeaderId = buf.readInt();
        if (partyLeaderId < 0)
            throw new RuntimeException("Forbidden value on partyLeaderId = " + partyLeaderId + ", it doesn't respect the following condition : partyLeaderId < 0");
        maxParticipants = buf.readByte();
        if (maxParticipants < 0)
            throw new RuntimeException("Forbidden value on maxParticipants = " + maxParticipants + ", it doesn't respect the following condition : maxParticipants < 0");
        int limit = buf.readUShort();
        members = new PartyMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            members[i].deserialize(buf);
        }
        limit = buf.readUShort();
        guests = new PartyGuestInformations[limit];
        for (int i = 0; i < limit; i++) {
            guests[i] = new PartyGuestInformations();
            guests[i].deserialize(buf);
        }
        restricted = buf.readBoolean();
    }
    
}
