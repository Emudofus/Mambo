

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeMountStableRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5964;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double mountId;
    
    public ExchangeMountStableRemoveMessage() { }
    
    public ExchangeMountStableRemoveMessage(double mountId) {
        this.mountId = mountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(mountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountId = buf.readDouble();
    }
    
}
