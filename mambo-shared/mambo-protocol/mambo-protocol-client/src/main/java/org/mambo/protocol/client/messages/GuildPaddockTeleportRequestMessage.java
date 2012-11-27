

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildPaddockTeleportRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5957;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int paddockId;
    
    public GuildPaddockTeleportRequestMessage() { }
    
    public GuildPaddockTeleportRequestMessage(int paddockId) {
        this.paddockId = paddockId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(paddockId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paddockId = reader.readInt();
    }
    
}
