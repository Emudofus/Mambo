

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeInt(fighterId1);
        writer.writeInt(fighterId2);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        fighterId1 = reader.readInt();
        if (fighterId1 < 0)
            throw new RuntimeException("Forbidden value on fighterId1 = " + fighterId1 + ", it doesn't respect the following condition : fighterId1 < 0");
        fighterId2 = reader.readInt();
        if (fighterId2 < 0)
            throw new RuntimeException("Forbidden value on fighterId2 = " + fighterId2 + ", it doesn't respect the following condition : fighterId2 < 0");
    }
    
}
