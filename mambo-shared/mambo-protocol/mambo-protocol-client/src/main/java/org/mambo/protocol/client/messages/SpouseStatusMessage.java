

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SpouseStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6265;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hasSpouse;
    
    public SpouseStatusMessage() { }
    
    public SpouseStatusMessage(boolean hasSpouse) {
        this.hasSpouse = hasSpouse;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(hasSpouse);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        hasSpouse = reader.readBoolean();
    }
    
}
