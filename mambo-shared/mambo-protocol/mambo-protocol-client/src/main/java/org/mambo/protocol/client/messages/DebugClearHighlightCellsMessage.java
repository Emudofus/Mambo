

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DebugClearHighlightCellsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 2002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public DebugClearHighlightCellsMessage() { }
    
    
    @Override
    public void serialize(DataWriterInterface writer) {
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
    }
    
}
