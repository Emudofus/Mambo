

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(proposedPrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        proposedPrice = buf.readInt();
        if (proposedPrice < 0)
            throw new RuntimeException("Forbidden value on proposedPrice = " + proposedPrice + ", it doesn't respect the following condition : proposedPrice < 0");
    }
    
}
