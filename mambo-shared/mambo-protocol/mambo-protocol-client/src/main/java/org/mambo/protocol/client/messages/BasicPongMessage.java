

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class BasicPongMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 183;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean quiet;
    
    public BasicPongMessage() { }
    
    public BasicPongMessage(boolean quiet) {
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
