

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobAllowMultiCraftRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5748;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    
    public JobAllowMultiCraftRequestMessage() { }
    
    public JobAllowMultiCraftRequestMessage(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        enabled = buf.readBoolean();
    }
    
}
