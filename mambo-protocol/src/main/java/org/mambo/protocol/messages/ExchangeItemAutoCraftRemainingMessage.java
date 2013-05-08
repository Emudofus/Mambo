

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeItemAutoCraftRemainingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6015;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int count;
    
    public ExchangeItemAutoCraftRemainingMessage() { }
    
    public ExchangeItemAutoCraftRemainingMessage(int count) {
        this.count = count;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(count);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        count = buf.readInt();
        if (count < 0)
            throw new RuntimeException("Forbidden value on count = " + count + ", it doesn't respect the following condition : count < 0");
    }
    
}
