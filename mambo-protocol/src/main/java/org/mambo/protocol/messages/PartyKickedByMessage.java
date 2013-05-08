

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyKickedByMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5590;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kickerId;
    
    public PartyKickedByMessage() { }
    
    public PartyKickedByMessage(int partyId, int kickerId) {
        super(partyId);
        this.kickerId = kickerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(kickerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        kickerId = buf.readInt();
        if (kickerId < 0)
            throw new RuntimeException("Forbidden value on kickerId = " + kickerId + ", it doesn't respect the following condition : kickerId < 0");
    }
    
}
