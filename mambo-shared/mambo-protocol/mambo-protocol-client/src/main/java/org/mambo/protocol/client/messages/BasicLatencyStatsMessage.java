

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class BasicLatencyStatsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5663;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int latency;
    public short sampleCount;
    public short max;
    
    public BasicLatencyStatsMessage() { }
    
    public BasicLatencyStatsMessage(int latency, short sampleCount, short max) {
        this.latency = latency;
        this.sampleCount = sampleCount;
        this.max = max;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(latency);
        writer.writeShort(sampleCount);
        writer.writeShort(max);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        latency = reader.readUnsignedShort();
        if (latency < 0 || latency > 65535)
            throw new RuntimeException("Forbidden value on latency = " + latency + ", it doesn't respect the following condition : latency < 0 || latency > 65535");
        sampleCount = reader.readShort();
        if (sampleCount < 0)
            throw new RuntimeException("Forbidden value on sampleCount = " + sampleCount + ", it doesn't respect the following condition : sampleCount < 0");
        max = reader.readShort();
        if (max < 0)
            throw new RuntimeException("Forbidden value on max = " + max + ", it doesn't respect the following condition : max < 0");
    }
    
}
