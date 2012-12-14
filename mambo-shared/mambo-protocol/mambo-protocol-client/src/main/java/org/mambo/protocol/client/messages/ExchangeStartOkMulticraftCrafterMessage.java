

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkMulticraftCrafterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5818;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte maxCase;
    public int skillId;
    
    public ExchangeStartOkMulticraftCrafterMessage() { }
    
    public ExchangeStartOkMulticraftCrafterMessage(byte maxCase, int skillId) {
        this.maxCase = maxCase;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(maxCase);
        writer.writeInt(skillId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        maxCase = reader.readByte();
        if (maxCase < 0)
            throw new RuntimeException("Forbidden value on maxCase = " + maxCase + ", it doesn't respect the following condition : maxCase < 0");
        skillId = reader.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
