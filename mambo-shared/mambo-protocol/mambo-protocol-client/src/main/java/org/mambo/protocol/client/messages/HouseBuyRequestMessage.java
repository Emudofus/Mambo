

// Generated on 11/11/2012 20:41:27
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HouseBuyRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5738;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int proposedPrice;
    
    public HouseBuyRequestMessage() { }
    
    public HouseBuyRequestMessage(int proposedPrice) {
        this.proposedPrice = proposedPrice;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(proposedPrice);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        proposedPrice = reader.readInt();
        if (proposedPrice < 0)
            throw new RuntimeException("Forbidden value on proposedPrice = " + proposedPrice + ", it doesn't respect the following condition : proposedPrice < 0");
    }
    
}
