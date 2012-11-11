

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
