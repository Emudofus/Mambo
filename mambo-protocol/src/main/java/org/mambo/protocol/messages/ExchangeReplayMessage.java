

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeReplayMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6002;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int count;
    
    public ExchangeReplayMessage() { }
    
    public ExchangeReplayMessage(int count) {
        this.count = count;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(count);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        count = buf.readInt();
    }
    
}
