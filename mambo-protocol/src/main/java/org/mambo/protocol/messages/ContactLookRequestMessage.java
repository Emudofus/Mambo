

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUByte(requestId);
        buf.writeByte(contactType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        requestId = buf.readUByte();
        if (requestId < 0 || requestId > 255)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0 || requestId > 255");
        contactType = buf.readByte();
        if (contactType < 0)
            throw new RuntimeException("Forbidden value on contactType = " + contactType + ", it doesn't respect the following condition : contactType < 0");
    }
    
}
