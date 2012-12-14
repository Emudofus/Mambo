

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GetPartInfoMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1506;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String id;
    
    public GetPartInfoMessage() { }
    
    public GetPartInfoMessage(String id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readString();
    }
    
}
