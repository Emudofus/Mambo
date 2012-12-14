

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeBidHousePriceMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5805;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int genId;
    
    public ExchangeBidHousePriceMessage() { }
    
    public ExchangeBidHousePriceMessage(int genId) {
        this.genId = genId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(genId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        genId = reader.readInt();
        if (genId < 0)
            throw new RuntimeException("Forbidden value on genId = " + genId + ", it doesn't respect the following condition : genId < 0");
    }
    
}
