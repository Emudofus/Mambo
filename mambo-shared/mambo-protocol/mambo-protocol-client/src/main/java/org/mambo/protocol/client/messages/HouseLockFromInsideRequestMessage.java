

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class HouseLockFromInsideRequestMessage extends LockableChangeCodeMessage {
    public static final int MESSAGE_ID = 5885;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public HouseLockFromInsideRequestMessage() { }
    
    public HouseLockFromInsideRequestMessage(String code) {
        super(code);
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
