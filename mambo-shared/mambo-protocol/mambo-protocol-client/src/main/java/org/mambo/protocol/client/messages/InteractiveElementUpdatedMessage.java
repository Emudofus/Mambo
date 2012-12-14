

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InteractiveElementUpdatedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5708;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public InteractiveElement interactiveElement;
    
    public InteractiveElementUpdatedMessage() { }
    
    public InteractiveElementUpdatedMessage(InteractiveElement interactiveElement) {
        this.interactiveElement = interactiveElement;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        interactiveElement.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        interactiveElement = new InteractiveElement();
        interactiveElement.deserialize(reader);
    }
    
}
