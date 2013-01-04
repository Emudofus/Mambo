

// Generated on 01/04/2013 14:54:32
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildInvitationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5551;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    
    public GuildInvitationMessage() { }
    
    public GuildInvitationMessage(int targetId) {
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        targetId = reader.readInt();
        if (targetId < 0)
            throw new RuntimeException("Forbidden value on targetId = " + targetId + ", it doesn't respect the following condition : targetId < 0");
    }
    
}
