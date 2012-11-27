

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class PartyRefuseInvitationNotificationMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5596;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int guestId;
    
    public PartyRefuseInvitationNotificationMessage() { }
    
    public PartyRefuseInvitationNotificationMessage(int partyId, int guestId) {
        super(partyId);
        this.guestId = guestId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(guestId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guestId = reader.readInt();
        if (guestId < 0)
            throw new RuntimeException("Forbidden value on guestId = " + guestId + ", it doesn't respect the following condition : guestId < 0");
    }
    
}
