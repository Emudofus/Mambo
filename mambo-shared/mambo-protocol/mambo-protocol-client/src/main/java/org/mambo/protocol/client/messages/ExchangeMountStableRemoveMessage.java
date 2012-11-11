

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeMountStableRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5964;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double mountId;
    
    public ExchangeMountStableRemoveMessage() { }
    
    public ExchangeMountStableRemoveMessage(double mountId) {
        this.mountId = mountId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(mountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountId = reader.readDouble();
    }
    
}
