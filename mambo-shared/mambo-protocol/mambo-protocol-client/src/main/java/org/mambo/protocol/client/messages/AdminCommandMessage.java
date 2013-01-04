

// Generated on 01/04/2013 14:54:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
