

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeReadyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5511;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean ready;
    public short step;
    
    public ExchangeReadyMessage() { }
    
    public ExchangeReadyMessage(boolean ready, short step) {
        this.ready = ready;
        this.step = step;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(ready);
        buf.writeShort(step);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        ready = buf.readBoolean();
        step = buf.readShort();
        if (step < 0)
            throw new RuntimeException("Forbidden value on step = " + step + ", it doesn't respect the following condition : step < 0");
    }
    
}
