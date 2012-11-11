

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
