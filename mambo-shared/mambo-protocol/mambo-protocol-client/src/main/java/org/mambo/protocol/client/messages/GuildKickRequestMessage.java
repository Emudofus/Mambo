

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildKickRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5887;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kickedId;
    
    public GuildKickRequestMessage() { }
    
    public GuildKickRequestMessage(int kickedId) {
        this.kickedId = kickedId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(kickedId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        kickedId = reader.readInt();
        if (kickedId < 0)
            throw new RuntimeException("Forbidden value on kickedId = " + kickedId + ", it doesn't respect the following condition : kickedId < 0");
    }
    
}
