

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountRidingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5967;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean isRiding;
    
    public MountRidingMessage() { }
    
    public MountRidingMessage(boolean isRiding) {
        this.isRiding = isRiding;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(isRiding);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        isRiding = buf.readBoolean();
    }
    
}
