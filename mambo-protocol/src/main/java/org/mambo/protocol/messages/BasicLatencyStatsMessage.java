

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(latency);
        buf.writeShort(sampleCount);
        buf.writeShort(max);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        latency = buf.readUShort();
        if (latency < 0 || latency > 65535)
            throw new RuntimeException("Forbidden value on latency = " + latency + ", it doesn't respect the following condition : latency < 0 || latency > 65535");
        sampleCount = buf.readShort();
        if (sampleCount < 0)
            throw new RuntimeException("Forbidden value on sampleCount = " + sampleCount + ", it doesn't respect the following condition : sampleCount < 0");
        max = buf.readShort();
        if (max < 0)
            throw new RuntimeException("Forbidden value on max = " + max + ", it doesn't respect the following condition : max < 0");
    }
    
}
