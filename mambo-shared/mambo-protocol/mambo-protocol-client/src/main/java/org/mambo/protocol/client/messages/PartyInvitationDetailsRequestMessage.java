

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class PartyInvitationDetailsRequestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6264;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyInvitationDetailsRequestMessage() { }
    
    public PartyInvitationDetailsRequestMessage(int partyId) {
        super(partyId);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
