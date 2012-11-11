

// Generated on 11/11/2012 19:17:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(invitationState);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        invitationState = reader.readByte();
        if (invitationState < 0)
            throw new RuntimeException("Forbidden value on invitationState = " + invitationState + ", it doesn't respect the following condition : invitationState < 0");
    }
    
}
