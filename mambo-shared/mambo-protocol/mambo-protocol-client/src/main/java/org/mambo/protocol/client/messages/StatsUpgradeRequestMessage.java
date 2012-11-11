

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StatsUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5610;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte statId;
    public short boostPoint;
    
    public StatsUpgradeRequestMessage() { }
    
    public StatsUpgradeRequestMessage(byte statId, short boostPoint) {
        this.statId = statId;
        this.boostPoint = boostPoint;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(statId);
        writer.writeShort(boostPoint);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        statId = reader.readByte();
        if (statId < 0)
            throw new RuntimeException("Forbidden value on statId = " + statId + ", it doesn't respect the following condition : statId < 0");
        boostPoint = reader.readShort();
        if (boostPoint < 0)
            throw new RuntimeException("Forbidden value on boostPoint = " + boostPoint + ", it doesn't respect the following condition : boostPoint < 0");
    }
    
}
