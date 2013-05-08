

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyCannotJoinErrorMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5583;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public PartyCannotJoinErrorMessage() { }
    
    public PartyCannotJoinErrorMessage(int partyId, byte reason) {
        super(partyId);
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        reason = buf.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
