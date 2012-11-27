

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicSwitchModeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6101;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte mode;
    
    public BasicSwitchModeRequestMessage() { }
    
    public BasicSwitchModeRequestMessage(byte mode) {
        this.mode = mode;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(mode);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mode = reader.readByte();
    }
    
}
