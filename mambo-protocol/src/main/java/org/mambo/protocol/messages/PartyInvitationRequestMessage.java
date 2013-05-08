

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyInvitationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5585;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public PartyInvitationRequestMessage() { }
    
    public PartyInvitationRequestMessage(String name) {
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
    }
    
}
