

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6269;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean loyal;
    
    public PartyPledgeLoyaltyRequestMessage() { }
    
    public PartyPledgeLoyaltyRequestMessage(int partyId, boolean loyal) {
        super(partyId);
        this.loyal = loyal;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(loyal);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        loyal = buf.readBoolean();
    }
    
}
