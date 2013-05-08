

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeGoldPaymentForCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5833;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean onlySuccess;
    public int goldSum;
    
    public ExchangeGoldPaymentForCraftMessage() { }
    
    public ExchangeGoldPaymentForCraftMessage(boolean onlySuccess, int goldSum) {
        this.onlySuccess = onlySuccess;
        this.goldSum = goldSum;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(onlySuccess);
        buf.writeInt(goldSum);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        onlySuccess = buf.readBoolean();
        goldSum = buf.readInt();
        if (goldSum < 0)
            throw new RuntimeException("Forbidden value on goldSum = " + goldSum + ", it doesn't respect the following condition : goldSum < 0");
    }
    
}
