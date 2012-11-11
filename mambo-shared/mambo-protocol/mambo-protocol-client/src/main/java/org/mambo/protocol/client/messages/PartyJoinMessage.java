

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(partyType);
        writer.writeInt(partyLeaderId);
        writer.writeByte(maxParticipants);
        writer.writeUnsignedShort(members.length);
        for (PartyMemberInformations entry : members) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(guests.length);
        for (PartyGuestInformations entry : guests) {
            entry.serialize(writer);
        }
        writer.writeBoolean(restricted);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        partyType = reader.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        partyLeaderId = reader.readInt();
        if (partyLeaderId < 0)
            throw new RuntimeException("Forbidden value on partyLeaderId = " + partyLeaderId + ", it doesn't respect the following condition : partyLeaderId < 0");
        maxParticipants = reader.readByte();
        if (maxParticipants < 0)
            throw new RuntimeException("Forbidden value on maxParticipants = " + maxParticipants + ", it doesn't respect the following condition : maxParticipants < 0");
        int limit = reader.readUnsignedShort();
        members = new PartyMemberInformations[limit];
        for (int i = 0; i < limit; i++) {
            members[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), PartyMemberInformations.class);
            members[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        guests = new PartyGuestInformations[limit];
        for (int i = 0; i < limit; i++) {
            guests[i] = new PartyGuestInformations();
            guests[i].deserialize(reader);
        }
        restricted = reader.readBoolean();
    }
    
}
