

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(active);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        active = reader.readBoolean();
    }
    
}
