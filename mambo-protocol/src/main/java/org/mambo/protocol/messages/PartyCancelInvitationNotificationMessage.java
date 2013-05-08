

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(cancelerId);
        buf.writeInt(guestId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cancelerId = buf.readInt();
        if (cancelerId < 0)
            throw new RuntimeException("Forbidden value on cancelerId = " + cancelerId + ", it doesn't respect the following condition : cancelerId < 0");
        guestId = buf.readInt();
        if (guestId < 0)
            throw new RuntimeException("Forbidden value on guestId = " + guestId + ", it doesn't respect the following condition : guestId < 0");
    }
    
}
