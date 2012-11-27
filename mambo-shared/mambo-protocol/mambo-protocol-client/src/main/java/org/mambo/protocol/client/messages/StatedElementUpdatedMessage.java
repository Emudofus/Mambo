

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StatedElementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5709;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public StatedElement statedElement;
    
    public StatedElementUpdatedMessage() { }
    
    public StatedElementUpdatedMessage(StatedElement statedElement) {
        this.statedElement = statedElement;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        statedElement.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        statedElement = new StatedElement();
        statedElement.deserialize(reader);
    }
    
}
