

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class BasicWhoIsRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 181;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String search;
    
    public BasicWhoIsRequestMessage() { }
    
    public BasicWhoIsRequestMessage(String search) {
        this.search = search;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(search);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        search = reader.readString();
    }
    
}
