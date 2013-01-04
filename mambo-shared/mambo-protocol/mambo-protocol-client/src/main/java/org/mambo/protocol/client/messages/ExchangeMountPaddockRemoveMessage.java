

// Generated on 01/04/2013 14:54:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMountPaddockRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6050;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double mountId;
    
    public ExchangeMountPaddockRemoveMessage() { }
    
    public ExchangeMountPaddockRemoveMessage(double mountId) {
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
