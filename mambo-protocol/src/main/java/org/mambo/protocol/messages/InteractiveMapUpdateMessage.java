

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveMapUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public InteractiveElement[] interactiveElements;
    
    public InteractiveMapUpdateMessage() { }
    
    public InteractiveMapUpdateMessage(InteractiveElement[] interactiveElements) {
        this.interactiveElements = interactiveElements;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(interactiveElements.length);
        for (InteractiveElement entry : interactiveElements) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        interactiveElements = new InteractiveElement[limit];
        for (int i = 0; i < limit; i++) {
            interactiveElements[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            interactiveElements[i].deserialize(buf);
        }
    }
    
}
