

// Generated on 01/04/2013 14:54:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyCancelInvitationNotificationMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 6251;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int cancelerId;
    public int guestId;
    
    public PartyCancelInvitationNotificationMessage() { }
    
    public PartyCancelInvitationNotificationMessage(int partyId, int cancelerId, int guestId) {
        super(partyId);
        this.cancelerId = cancelerId;
        this.guestId = guestId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(cancelerId);
        writer.writeInt(guestId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cancelerId = reader.readInt();
        if (cancelerId < 0)
            throw new RuntimeException("Forbidden value on cancelerId = " + cancelerId + ", it doesn't respect the following condition : cancelerId < 0");
        guestId = reader.readInt();
        if (guestId < 0)
            throw new RuntimeException("Forbidden value on guestId = " + guestId + ", it doesn't respect the following condition : guestId < 0");
    }
    
}
