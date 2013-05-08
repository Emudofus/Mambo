

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInvitationStateRecrutedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5548;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte invitationState;
    
    public GuildInvitationStateRecrutedMessage() { }
    
    public GuildInvitationStateRecrutedMessage(byte invitationState) {
        this.invitationState = invitationState;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(invitationState);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        invitationState = buf.readByte();
        if (invitationState < 0)
            throw new RuntimeException("Forbidden value on invitationState = " + invitationState + ", it doesn't respect the following condition : invitationState < 0");
    }
    
}
