

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
