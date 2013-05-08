

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class StatedMapUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5716;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public StatedElement[] statedElements;
    
    public StatedMapUpdateMessage() { }
    
    public StatedMapUpdateMessage(StatedElement[] statedElements) {
        this.statedElements = statedElements;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(statedElements.length);
        for (StatedElement entry : statedElements) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        statedElements = new StatedElement[limit];
        for (int i = 0; i < limit; i++) {
            statedElements[i] = new StatedElement();
            statedElements[i].deserialize(buf);
        }
    }
    
}
