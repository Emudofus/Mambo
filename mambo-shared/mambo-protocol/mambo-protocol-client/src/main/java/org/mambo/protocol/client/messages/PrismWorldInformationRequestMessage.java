

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismWorldInformationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5985;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean join;
    
    public PrismWorldInformationRequestMessage() { }
    
    public PrismWorldInformationRequestMessage(boolean join) {
        this.join = join;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(join);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        join = reader.readBoolean();
    }
    
}
