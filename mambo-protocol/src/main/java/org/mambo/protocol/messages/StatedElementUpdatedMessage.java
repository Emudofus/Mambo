

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        statedElement.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        statedElement = new StatedElement();
        statedElement.deserialize(buf);
    }
    
}
