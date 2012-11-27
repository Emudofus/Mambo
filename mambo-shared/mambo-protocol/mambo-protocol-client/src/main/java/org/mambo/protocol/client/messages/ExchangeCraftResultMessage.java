

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeCraftResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5790;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte craftResult;
    
    public ExchangeCraftResultMessage() { }
    
    public ExchangeCraftResultMessage(byte craftResult) {
        this.craftResult = craftResult;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(craftResult);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        craftResult = reader.readByte();
        if (craftResult < 0)
            throw new RuntimeException("Forbidden value on craftResult = " + craftResult + ", it doesn't respect the following condition : craftResult < 0");
    }
    
}
