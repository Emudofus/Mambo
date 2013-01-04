

// Generated on 01/04/2013 14:54:42
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
