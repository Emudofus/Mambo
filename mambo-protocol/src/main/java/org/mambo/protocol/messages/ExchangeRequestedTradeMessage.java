

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeRequestedTradeMessage extends ExchangeRequestedMessage {
    public static final int MESSAGE_ID = 5523;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int source;
    public int target;
    
    public ExchangeRequestedTradeMessage() { }
    
    public ExchangeRequestedTradeMessage(byte exchangeType, int source, int target) {
        super(exchangeType);
        this.source = source;
        this.target = target;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(source);
        buf.writeInt(target);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        source = buf.readInt();
        if (source < 0)
            throw new RuntimeException("Forbidden value on source = " + source + ", it doesn't respect the following condition : source < 0");
        target = buf.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
    }
    
}
