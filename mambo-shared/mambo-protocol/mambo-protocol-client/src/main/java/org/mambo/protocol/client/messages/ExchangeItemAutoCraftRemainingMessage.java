

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(count);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        count = reader.readInt();
        if (count < 0)
            throw new RuntimeException("Forbidden value on count = " + count + ", it doesn't respect the following condition : count < 0");
    }
    
}
