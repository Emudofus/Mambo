

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ServerSelectionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 40;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short serverId;
    
    public ServerSelectionMessage() { }
    
    public ServerSelectionMessage(short serverId) {
        this.serverId = serverId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(serverId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        serverId = reader.readShort();
    }
    
}
