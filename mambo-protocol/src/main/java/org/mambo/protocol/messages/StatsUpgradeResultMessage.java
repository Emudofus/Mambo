

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(nbCharacBoost);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        nbCharacBoost = buf.readShort();
        if (nbCharacBoost < 0)
            throw new RuntimeException("Forbidden value on nbCharacBoost = " + nbCharacBoost + ", it doesn't respect the following condition : nbCharacBoost < 0");
    }
    
}
