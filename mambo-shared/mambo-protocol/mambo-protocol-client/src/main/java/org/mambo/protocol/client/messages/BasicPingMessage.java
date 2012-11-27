

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicPingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 182;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean quiet;
    
    public BasicPingMessage() { }
    
    public BasicPingMessage(boolean quiet) {
        this.quiet = quiet;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(quiet);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        quiet = reader.readBoolean();
    }
    
}
