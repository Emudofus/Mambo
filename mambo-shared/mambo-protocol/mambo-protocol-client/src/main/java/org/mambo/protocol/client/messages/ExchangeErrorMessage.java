

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5513;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte errorType;
    
    public ExchangeErrorMessage() { }
    
    public ExchangeErrorMessage(byte errorType) {
        this.errorType = errorType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(errorType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        errorType = reader.readByte();
    }
    
}
