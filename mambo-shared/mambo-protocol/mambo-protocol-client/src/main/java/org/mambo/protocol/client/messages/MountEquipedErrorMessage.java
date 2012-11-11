

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
