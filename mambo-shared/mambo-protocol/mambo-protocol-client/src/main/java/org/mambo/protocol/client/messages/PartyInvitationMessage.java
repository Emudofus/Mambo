

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyInvitationMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5586;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte partyType;
    public byte maxParticipants;
    public int fromId;
    public String fromName;
    public int toId;
    
    public PartyInvitationMessage() { }
    
    public PartyInvitationMessage(int partyId, byte partyType, byte maxParticipants, int fromId, String fromName, int toId) {
        super(partyId);
        this.partyType = partyType;
        this.maxParticipants = maxParticipants;
        this.fromId = fromId;
        this.fromName = fromName;
        this.toId = toId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(partyType);
        writer.writeByte(maxParticipants);
        writer.writeInt(fromId);
        writer.writeString(fromName);
        writer.writeInt(toId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        partyType = reader.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        maxParticipants = reader.readByte();
        if (maxParticipants < 0)
            throw new RuntimeException("Forbidden value on maxParticipants = " + maxParticipants + ", it doesn't respect the following condition : maxParticipants < 0");
        fromId = reader.readInt();
        if (fromId < 0)
            throw new RuntimeException("Forbidden value on fromId = " + fromId + ", it doesn't respect the following condition : fromId < 0");
        fromName = reader.readString();
        toId = reader.readInt();
        if (toId < 0)
            throw new RuntimeException("Forbidden value on toId = " + toId + ", it doesn't respect the following condition : toId < 0");
    }
    
}
