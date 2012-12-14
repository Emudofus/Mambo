

// Generated on 12/14/2012 18:44:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ContactLookErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6045;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int requestId;
    
    public ContactLookErrorMessage() { }
    
    public ContactLookErrorMessage(int requestId) {
        this.requestId = requestId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(requestId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        requestId = reader.readInt();
        if (requestId < 0)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0");
    }
    
}
