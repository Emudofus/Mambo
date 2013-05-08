

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        interactiveElement.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        interactiveElement = new InteractiveElement();
        interactiveElement.deserialize(buf);
    }
    
}
