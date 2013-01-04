

// Generated on 01/04/2013 14:54:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
