

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyAcceptInvitationMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5580;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyAcceptInvitationMessage() { }
    
    public PartyAcceptInvitationMessage(int partyId) {
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
