

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
