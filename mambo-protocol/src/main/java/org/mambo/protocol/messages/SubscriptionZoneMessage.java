

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SubscriptionZoneMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5573;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean active;
    
    public SubscriptionZoneMessage() { }
    
    public SubscriptionZoneMessage(boolean active) {
        this.active = active;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(active);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        active = buf.readBoolean();
    }
    
}
