

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeOkMultiCraftMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5768;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int initiatorId;
    public int otherId;
    public byte role;
    
    public ExchangeOkMultiCraftMessage() { }
    
    public ExchangeOkMultiCraftMessage(int initiatorId, int otherId, byte role) {
        this.initiatorId = initiatorId;
        this.otherId = otherId;
        this.role = role;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(initiatorId);
        writer.writeInt(otherId);
        writer.writeByte(role);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        initiatorId = reader.readInt();
        if (initiatorId < 0)
            throw new RuntimeException("Forbidden value on initiatorId = " + initiatorId + ", it doesn't respect the following condition : initiatorId < 0");
        otherId = reader.readInt();
        if (otherId < 0)
            throw new RuntimeException("Forbidden value on otherId = " + otherId + ", it doesn't respect the following condition : otherId < 0");
        role = reader.readByte();
    }
    
}
