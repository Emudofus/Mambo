

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ContactLookRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5932;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short requestId;
    public byte contactType;
    
    public ContactLookRequestMessage() { }
    
    public ContactLookRequestMessage(short requestId, byte contactType) {
        this.requestId = requestId;
        this.contactType = contactType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedByte(requestId);
        writer.writeByte(contactType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        requestId = reader.readUnsignedByte();
        if (requestId < 0 || requestId > 255)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0 || requestId > 255");
        contactType = reader.readByte();
        if (contactType < 0)
            throw new RuntimeException("Forbidden value on contactType = " + contactType + ", it doesn't respect the following condition : contactType < 0");
    }
    
}
