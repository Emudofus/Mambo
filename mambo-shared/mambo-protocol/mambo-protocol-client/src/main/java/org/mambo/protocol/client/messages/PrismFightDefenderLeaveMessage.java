

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismFightDefenderLeaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5892;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int fighterToRemoveId;
    public int successor;
    
    public PrismFightDefenderLeaveMessage() { }
    
    public PrismFightDefenderLeaveMessage(double fightId, int fighterToRemoveId, int successor) {
        this.fightId = fightId;
        this.fighterToRemoveId = fighterToRemoveId;
        this.successor = successor;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeInt(fighterToRemoveId);
        writer.writeInt(successor);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        fighterToRemoveId = reader.readInt();
        if (fighterToRemoveId < 0)
            throw new RuntimeException("Forbidden value on fighterToRemoveId = " + fighterToRemoveId + ", it doesn't respect the following condition : fighterToRemoveId < 0");
        successor = reader.readInt();
        if (successor < 0)
            throw new RuntimeException("Forbidden value on successor = " + successor + ", it doesn't respect the following condition : successor < 0");
    }
    
}
