

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class SetEnablePVPRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1810;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    
    public SetEnablePVPRequestMessage() { }
    
    public SetEnablePVPRequestMessage(boolean enable) {
        this.enable = enable;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(enable);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        enable = reader.readBoolean();
    }
    
}
