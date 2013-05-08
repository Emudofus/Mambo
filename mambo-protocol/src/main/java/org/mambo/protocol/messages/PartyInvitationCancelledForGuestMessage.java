

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(cancelerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cancelerId = buf.readInt();
        if (cancelerId < 0)
            throw new RuntimeException("Forbidden value on cancelerId = " + cancelerId + ", it doesn't respect the following condition : cancelerId < 0");
    }
    
}
