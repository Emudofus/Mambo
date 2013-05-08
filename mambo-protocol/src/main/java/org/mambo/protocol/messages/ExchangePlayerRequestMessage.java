

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangePlayerRequestMessage extends ExchangeRequestMessage {
    public static final int MESSAGE_ID = 5773;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int target;
    
    public ExchangePlayerRequestMessage() { }
    
    public ExchangePlayerRequestMessage(byte exchangeType, int target) {
        super(exchangeType);
        this.target = target;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(target);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        target = buf.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
    }
    
}
