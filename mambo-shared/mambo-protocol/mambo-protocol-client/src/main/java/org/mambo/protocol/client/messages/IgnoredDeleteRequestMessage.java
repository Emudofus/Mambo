

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class IgnoredDeleteRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5680;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public boolean session;
    
    public IgnoredDeleteRequestMessage() { }
    
    public IgnoredDeleteRequestMessage(String name, boolean session) {
        this.name = name;
        this.session = session;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
        writer.writeBoolean(session);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
        session = reader.readBoolean();
    }
    
}
