

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeString(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readString();
    }
    
}
