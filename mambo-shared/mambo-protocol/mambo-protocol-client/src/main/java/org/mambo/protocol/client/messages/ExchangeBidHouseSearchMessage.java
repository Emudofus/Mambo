

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeBidHouseSearchMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5806;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int type;
    public int genId;
    
    public ExchangeBidHouseSearchMessage() { }
    
    public ExchangeBidHouseSearchMessage(int type, int genId) {
        this.type = type;
        this.genId = genId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(type);
        writer.writeInt(genId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        type = reader.readInt();
        if (type < 0)
            throw new RuntimeException("Forbidden value on type = " + type + ", it doesn't respect the following condition : type < 0");
        genId = reader.readInt();
        if (genId < 0)
            throw new RuntimeException("Forbidden value on genId = " + genId + ", it doesn't respect the following condition : genId < 0");
    }
    
}
