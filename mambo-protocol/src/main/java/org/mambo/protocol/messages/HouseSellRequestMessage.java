

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseSellRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5697;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int amount;
    
    public HouseSellRequestMessage() { }
    
    public HouseSellRequestMessage(int amount) {
        this.amount = amount;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(amount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        amount = buf.readInt();
        if (amount < 0)
            throw new RuntimeException("Forbidden value on amount = " + amount + ", it doesn't respect the following condition : amount < 0");
    }
    
}
