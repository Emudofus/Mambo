

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildInvitationAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5556;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean accept;
    
    public GuildInvitationAnswerMessage() { }
    
    public GuildInvitationAnswerMessage(boolean accept) {
        this.accept = accept;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(accept);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        accept = reader.readBoolean();
    }
    
}
