

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LifePointsRegenBeginMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5684;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short regenRate;
    
    public LifePointsRegenBeginMessage() { }
    
    public LifePointsRegenBeginMessage(short regenRate) {
        this.regenRate = regenRate;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedByte(regenRate);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        regenRate = reader.readUnsignedByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
    }
    
}
