

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(requestId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        requestId = buf.readInt();
        if (requestId < 0)
            throw new RuntimeException("Forbidden value on requestId = " + requestId + ", it doesn't respect the following condition : requestId < 0");
    }
    
}
