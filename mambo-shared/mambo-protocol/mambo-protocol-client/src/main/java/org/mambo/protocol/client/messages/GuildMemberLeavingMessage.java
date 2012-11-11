

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildMemberLeavingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5923;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean kicked;
    public int memberId;
    
    public GuildMemberLeavingMessage() { }
    
    public GuildMemberLeavingMessage(boolean kicked, int memberId) {
        this.kicked = kicked;
        this.memberId = memberId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(kicked);
        writer.writeInt(memberId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        kicked = reader.readBoolean();
        memberId = reader.readInt();
    }
    
}
