

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6256;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int cancelerId;
    
    public PartyInvitationCancelledForGuestMessage() { }
    
    public PartyInvitationCancelledForGuestMessage(int partyId, int cancelerId) {
        super(partyId);
        this.cancelerId = cancelerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(cancelerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cancelerId = reader.readInt();
        if (cancelerId < 0)
            throw new RuntimeException("Forbidden value on cancelerId = " + cancelerId + ", it doesn't respect the following condition : cancelerId < 0");
    }
    
}
