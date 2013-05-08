

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyFollowThisMemberRequestMessage extends PartyFollowMemberRequestMessage {
    public static final int MESSAGE_ID = 5588;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    
    public PartyFollowThisMemberRequestMessage() { }
    
    public PartyFollowThisMemberRequestMessage(int partyId, int playerId, boolean enabled) {
        super(partyId, playerId);
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        enabled = buf.readBoolean();
    }
    
}
