

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5581;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public int followedId;
    
    public PartyFollowStatusUpdateMessage() { }
    
    public PartyFollowStatusUpdateMessage(int partyId, boolean success, int followedId) {
        super(partyId);
        this.success = success;
        this.followedId = followedId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(success);
        buf.writeInt(followedId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        success = buf.readBoolean();
        followedId = buf.readInt();
        if (followedId < 0)
            throw new RuntimeException("Forbidden value on followedId = " + followedId + ", it doesn't respect the following condition : followedId < 0");
    }
    
}
