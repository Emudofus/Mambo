

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightNewRoundMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6239;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int roundNumber;
    
    public GameFightNewRoundMessage() { }
    
    public GameFightNewRoundMessage(int roundNumber) {
        this.roundNumber = roundNumber;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(roundNumber);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        roundNumber = reader.readInt();
        if (roundNumber < 0)
            throw new RuntimeException("Forbidden value on roundNumber = " + roundNumber + ", it doesn't respect the following condition : roundNumber < 0");
    }
    
}
