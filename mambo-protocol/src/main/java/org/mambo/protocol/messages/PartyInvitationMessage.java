

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(partyType);
        buf.writeByte(maxParticipants);
        buf.writeInt(fromId);
        buf.writeString(fromName);
        buf.writeInt(toId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        partyType = buf.readByte();
        if (partyType < 0)
            throw new RuntimeException("Forbidden value on partyType = " + partyType + ", it doesn't respect the following condition : partyType < 0");
        maxParticipants = buf.readByte();
        if (maxParticipants < 0)
            throw new RuntimeException("Forbidden value on maxParticipants = " + maxParticipants + ", it doesn't respect the following condition : maxParticipants < 0");
        fromId = buf.readInt();
        if (fromId < 0)
            throw new RuntimeException("Forbidden value on fromId = " + fromId + ", it doesn't respect the following condition : fromId < 0");
        fromName = buf.readString();
        toId = buf.readInt();
        if (toId < 0)
            throw new RuntimeException("Forbidden value on toId = " + toId + ", it doesn't respect the following condition : toId < 0");
    }
    
}
