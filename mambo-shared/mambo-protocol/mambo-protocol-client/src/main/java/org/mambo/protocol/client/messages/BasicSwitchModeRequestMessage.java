

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
