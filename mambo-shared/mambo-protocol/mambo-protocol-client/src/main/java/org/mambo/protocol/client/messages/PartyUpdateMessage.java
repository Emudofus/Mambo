

// Generated on 01/04/2013 14:54:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyUpdateMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5575;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PartyMemberInformations memberInformations;
    
    public PartyUpdateMessage() { }
    
    public PartyUpdateMessage(int partyId, PartyMemberInformations memberInformations) {
        super(partyId);
        this.memberInformations = memberInformations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(memberInformations.getTypeId());
        memberInformations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        memberInformations = ProtocolTypeManager.getInstance().build(reader.readShort(), PartyMemberInformations.class);
        memberInformations.deserialize(reader);
    }
    
}
