

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(onlySuccess);
        writer.writeInt(goldSum);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        onlySuccess = reader.readBoolean();
        goldSum = reader.readInt();
        if (goldSum < 0)
            throw new RuntimeException("Forbidden value on goldSum = " + goldSum + ", it doesn't respect the following condition : goldSum < 0");
    }
    
}
