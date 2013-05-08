

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeByte(statId);
        buf.writeShort(boostPoint);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        statId = buf.readByte();
        if (statId < 0)
            throw new RuntimeException("Forbidden value on statId = " + statId + ", it doesn't respect the following condition : statId < 0");
        boostPoint = buf.readShort();
        if (boostPoint < 0)
            throw new RuntimeException("Forbidden value on boostPoint = " + boostPoint + ", it doesn't respect the following condition : boostPoint < 0");
    }
    
}
