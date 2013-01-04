

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismFightAttackerRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5897;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public int fighterToRemoveId;
    
    public PrismFightAttackerRemoveMessage() { }
    
    public PrismFightAttackerRemoveMessage(double fightId, int fighterToRemoveId) {
        this.fightId = fightId;
        this.fighterToRemoveId = fighterToRemoveId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeInt(fighterToRemoveId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        fighterToRemoveId = reader.readInt();
        if (fighterToRemoveId < 0)
            throw new RuntimeException("Forbidden value on fighterToRemoveId = " + fighterToRemoveId + ", it doesn't respect the following condition : fighterToRemoveId < 0");
    }
    
}
