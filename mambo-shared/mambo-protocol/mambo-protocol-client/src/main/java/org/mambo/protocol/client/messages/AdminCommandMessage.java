

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AdminCommandMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 76;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String content;
    
    public AdminCommandMessage() { }
    
    public AdminCommandMessage(String content) {
        this.content = content;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(content);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        content = reader.readString();
    }
    
}
