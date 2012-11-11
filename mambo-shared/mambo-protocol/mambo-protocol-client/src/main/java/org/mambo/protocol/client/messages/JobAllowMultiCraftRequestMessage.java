

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobAllowMultiCraftRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5748;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    
    public JobAllowMultiCraftRequestMessage() { }
    
    public JobAllowMultiCraftRequestMessage(boolean enabled) {
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
