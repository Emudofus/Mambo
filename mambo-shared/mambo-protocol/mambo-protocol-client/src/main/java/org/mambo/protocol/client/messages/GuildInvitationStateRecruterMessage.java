

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeString(recrutedName);
        writer.writeByte(invitationState);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        recrutedName = reader.readString();
        invitationState = reader.readByte();
        if (invitationState < 0)
            throw new RuntimeException("Forbidden value on invitationState = " + invitationState + ", it doesn't respect the following condition : invitationState < 0");
    }
    
}
