

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeString(search);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        search = buf.readString();
    }
    
}
