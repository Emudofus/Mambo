

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyMemberRemoveMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5579;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int leavingPlayerId;
    
    public PartyMemberRemoveMessage() { }
    
    public PartyMemberRemoveMessage(int partyId, int leavingPlayerId) {
        super(partyId);
        this.leavingPlayerId = leavingPlayerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(leavingPlayerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        leavingPlayerId = buf.readInt();
        if (leavingPlayerId < 0)
            throw new RuntimeException("Forbidden value on leavingPlayerId = " + leavingPlayerId + ", it doesn't respect the following condition : leavingPlayerId < 0");
    }
    
}
