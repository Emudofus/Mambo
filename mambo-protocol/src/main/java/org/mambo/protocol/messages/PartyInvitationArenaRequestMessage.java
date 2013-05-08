

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyInvitationArenaRequestMessage extends PartyInvitationRequestMessage {
    public static final int MESSAGE_ID = 6283;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyInvitationArenaRequestMessage() { }
    
    public PartyInvitationArenaRequestMessage(String name) {
        super(name);
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
