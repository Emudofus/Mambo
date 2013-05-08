

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LockableStateUpdateAbstractMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5671;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean locked;
    
    public LockableStateUpdateAbstractMessage() { }
    
    public LockableStateUpdateAbstractMessage(boolean locked) {
        this.locked = locked;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(locked);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        locked = buf.readBoolean();
    }
    
}
