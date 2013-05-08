

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightDefendersSwapMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5902;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int fighterId1;
    public int fighterId2;
    
    public PrismFightDefendersSwapMessage() { }
    
    public PrismFightDefendersSwapMessage(double fightId, int fighterId1, int fighterId2) {
        this.fightId = fightId;
        this.fighterId1 = fighterId1;
        this.fighterId2 = fighterId2;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeInt(fighterId1);
        buf.writeInt(fighterId2);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        fighterId1 = buf.readInt();
        if (fighterId1 < 0)
            throw new RuntimeException("Forbidden value on fighterId1 = " + fighterId1 + ", it doesn't respect the following condition : fighterId1 < 0");
        fighterId2 = buf.readInt();
        if (fighterId2 < 0)
            throw new RuntimeException("Forbidden value on fighterId2 = " + fighterId2 + ", it doesn't respect the following condition : fighterId2 < 0");
    }
    
}
