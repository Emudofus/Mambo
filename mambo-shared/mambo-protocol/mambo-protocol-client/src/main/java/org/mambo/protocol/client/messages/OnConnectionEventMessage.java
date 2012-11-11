

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class OnConnectionEventMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5726;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte eventType;
    
    public OnConnectionEventMessage() { }
    
    public OnConnectionEventMessage(byte eventType) {
        this.eventType = eventType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(eventType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        eventType = reader.readByte();
        if (eventType < 0)
            throw new RuntimeException("Forbidden value on eventType = " + eventType + ", it doesn't respect the following condition : eventType < 0");
    }
    
}
