

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyRestrictedMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6175;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean restricted;
    
    public PartyRestrictedMessage() { }
    
    public PartyRestrictedMessage(int partyId, boolean restricted) {
        super(partyId);
        this.restricted = restricted;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(restricted);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        restricted = buf.readBoolean();
    }
    
}
