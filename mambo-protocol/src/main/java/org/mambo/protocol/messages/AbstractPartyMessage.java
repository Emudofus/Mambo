

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractPartyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6274;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int partyId;
    
    public AbstractPartyMessage() { }
    
    public AbstractPartyMessage(int partyId) {
        this.partyId = partyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(partyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        partyId = buf.readInt();
        if (partyId < 0)
            throw new RuntimeException("Forbidden value on partyId = " + partyId + ", it doesn't respect the following condition : partyId < 0");
    }
    
}
