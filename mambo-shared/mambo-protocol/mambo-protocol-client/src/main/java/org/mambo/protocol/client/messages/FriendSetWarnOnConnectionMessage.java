

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FriendSetWarnOnConnectionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5602;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    
    public FriendSetWarnOnConnectionMessage() { }
    
    public FriendSetWarnOnConnectionMessage(boolean enable) {
        this.enable = enable;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(enable);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        enable = reader.readBoolean();
    }
    
}
