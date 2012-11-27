

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobAllowMultiCraftRequestSetMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5749;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    
    public JobAllowMultiCraftRequestSetMessage() { }
    
    public JobAllowMultiCraftRequestSetMessage(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        enabled = reader.readBoolean();
    }
    
}
