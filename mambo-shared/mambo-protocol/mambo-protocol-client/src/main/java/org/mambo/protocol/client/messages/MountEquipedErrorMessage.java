

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MountEquipedErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5963;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte errorType;
    
    public MountEquipedErrorMessage() { }
    
    public MountEquipedErrorMessage(byte errorType) {
        this.errorType = errorType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(errorType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        errorType = reader.readByte();
        if (errorType < 0)
            throw new RuntimeException("Forbidden value on errorType = " + errorType + ", it doesn't respect the following condition : errorType < 0");
    }
    
}
