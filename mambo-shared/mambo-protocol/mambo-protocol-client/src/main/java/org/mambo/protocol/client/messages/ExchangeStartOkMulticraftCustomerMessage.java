

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkMulticraftCustomerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5817;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte maxCase;
    public int skillId;
    public byte crafterJobLevel;
    
    public ExchangeStartOkMulticraftCustomerMessage() { }
    
    public ExchangeStartOkMulticraftCustomerMessage(byte maxCase, int skillId, byte crafterJobLevel) {
        this.maxCase = maxCase;
        this.skillId = skillId;
        this.crafterJobLevel = crafterJobLevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(maxCase);
        writer.writeInt(skillId);
        writer.writeByte(crafterJobLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        maxCase = reader.readByte();
        if (maxCase < 0)
            throw new RuntimeException("Forbidden value on maxCase = " + maxCase + ", it doesn't respect the following condition : maxCase < 0");
        skillId = reader.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
        crafterJobLevel = reader.readByte();
        if (crafterJobLevel < 0)
            throw new RuntimeException("Forbidden value on crafterJobLevel = " + crafterJobLevel + ", it doesn't respect the following condition : crafterJobLevel < 0");
    }
    
}
