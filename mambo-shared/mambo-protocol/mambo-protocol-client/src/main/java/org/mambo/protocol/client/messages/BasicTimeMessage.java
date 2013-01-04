

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicTimeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 175;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int timestamp;
    public short timezoneOffset;
    
    public BasicTimeMessage() { }
    
    public BasicTimeMessage(int timestamp, short timezoneOffset) {
        this.timestamp = timestamp;
        this.timezoneOffset = timezoneOffset;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(timestamp);
        writer.writeShort(timezoneOffset);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        timestamp = reader.readInt();
        if (timestamp < 0)
            throw new RuntimeException("Forbidden value on timestamp = " + timestamp + ", it doesn't respect the following condition : timestamp < 0");
        timezoneOffset = reader.readShort();
    }
    
}
