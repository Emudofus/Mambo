

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StatsUpgradeResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5609;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short nbCharacBoost;
    
    public StatsUpgradeResultMessage() { }
    
    public StatsUpgradeResultMessage(short nbCharacBoost) {
        this.nbCharacBoost = nbCharacBoost;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(nbCharacBoost);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        nbCharacBoost = reader.readShort();
        if (nbCharacBoost < 0)
            throw new RuntimeException("Forbidden value on nbCharacBoost = " + nbCharacBoost + ", it doesn't respect the following condition : nbCharacBoost < 0");
    }
    
}
