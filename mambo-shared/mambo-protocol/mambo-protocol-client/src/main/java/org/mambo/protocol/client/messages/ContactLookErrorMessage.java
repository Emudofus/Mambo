

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

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
