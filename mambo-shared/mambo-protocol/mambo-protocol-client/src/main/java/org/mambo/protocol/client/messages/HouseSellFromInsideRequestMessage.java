

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class HouseSellFromInsideRequestMessage extends HouseSellRequestMessage {
    public static final int MESSAGE_ID = 5884;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public HouseSellFromInsideRequestMessage() { }
    
    public HouseSellFromInsideRequestMessage(int amount) {
        super(amount);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
