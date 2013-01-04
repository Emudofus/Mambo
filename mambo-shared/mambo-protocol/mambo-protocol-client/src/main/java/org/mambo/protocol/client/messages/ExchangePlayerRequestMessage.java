

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(target);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        target = reader.readInt();
        if (target < 0)
            throw new RuntimeException("Forbidden value on target = " + target + ", it doesn't respect the following condition : target < 0");
    }
    
}
