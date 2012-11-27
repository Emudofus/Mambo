

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ClientKeyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5607;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String key;
    
    public ClientKeyMessage() { }
    
    public ClientKeyMessage(String key) {
        this.key = key;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(key);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        key = reader.readString();
    }
    
}
