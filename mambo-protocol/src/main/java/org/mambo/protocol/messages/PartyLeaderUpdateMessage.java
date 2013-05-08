

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyLeaderUpdateMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5578;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int partyLeaderId;
    
    public PartyLeaderUpdateMessage() { }
    
    public PartyLeaderUpdateMessage(int partyId, int partyLeaderId) {
        super(partyId);
        this.partyLeaderId = partyLeaderId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(partyLeaderId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        partyLeaderId = buf.readInt();
        if (partyLeaderId < 0)
            throw new RuntimeException("Forbidden value on partyLeaderId = " + partyLeaderId + ", it doesn't respect the following condition : partyLeaderId < 0");
    }
    
}
