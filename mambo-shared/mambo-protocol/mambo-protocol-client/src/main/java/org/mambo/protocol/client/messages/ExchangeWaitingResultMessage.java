

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeWaitingResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5786;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean bwait;
    
    public ExchangeWaitingResultMessage() { }
    
    public ExchangeWaitingResultMessage(boolean bwait) {
        this.bwait = bwait;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(bwait);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        bwait = reader.readBoolean();
    }
    
}
