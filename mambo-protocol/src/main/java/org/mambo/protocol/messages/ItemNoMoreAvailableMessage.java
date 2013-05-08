

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ItemNoMoreAvailableMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5769;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public ItemNoMoreAvailableMessage() { }
    
    
    @Override
    public void serialize(Buffer buf) {
    }
    
    @Override
    public void deserialize(Buffer buf) {
    }
    
}
