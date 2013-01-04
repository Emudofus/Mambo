

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(amount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        amount = reader.readInt();
        if (amount < 0)
            throw new RuntimeException("Forbidden value on amount = " + amount + ", it doesn't respect the following condition : amount < 0");
    }
    
}
