

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(partyType);
        writer.writeInt(fromId);
        writer.writeString(fromName);
        writer.writeInt(leaderId);
        writer.writeUnsignedShort(members.length);
        for (PartyInvitationMemberInformations entry : members) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(guests.length);
        for (PartyGuestInformations entry : guests) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        partyType = reader.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        fromId = reader.readInt();
        if (fromId < 0)
            throw new RuntimeException("Forbidden value on fromId = " + fromId + ", it doesn't respect the following condition : fromId < 0");
        fromName = reader.readString();
        leaderId = reader.readInt();
        if (leaderId < 0)
            throw new RuntimeException("Forbidden value on leaderId = " + leaderId + ", it doesn't respect the following condition : leaderId < 0");
        int limit = reader.readUnsignedShort();
        members = new PartyInvitationMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = new PartyInvitationMemberInformations();
            members[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        guests = new PartyGuestInformations[limit];
        for (int i = 0; i < limit; i++) {
            guests[i] = new PartyGuestInformations();
            guests[i].deserialize(reader);
        }
    }
    
}
