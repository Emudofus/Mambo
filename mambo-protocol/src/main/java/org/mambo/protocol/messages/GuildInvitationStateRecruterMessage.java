

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInvitationStateRecruterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5563;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String recrutedName;
    public byte invitationState;
    
    public GuildInvitationStateRecruterMessage() { }
    
    public GuildInvitationStateRecruterMessage(String recrutedName, byte invitationState) {
        this.recrutedName = recrutedName;
        this.invitationState = invitationState;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(recrutedName);
        buf.writeByte(invitationState);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        recrutedName = buf.readString();
        invitationState = buf.readByte();
        if (invitationState < 0)
            throw new RuntimeException("Forbidden value on invitationState = " + invitationState + ", it doesn't respect the following condition : invitationState < 0");
    }
    
}
