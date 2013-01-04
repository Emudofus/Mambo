

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseTypeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5803;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int type;
    
    public ExchangeBidHouseTypeMessage() { }
    
    public ExchangeBidHouseTypeMessage(int type) {
        this.type = type;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(type);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readInt();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
    }
    
}
