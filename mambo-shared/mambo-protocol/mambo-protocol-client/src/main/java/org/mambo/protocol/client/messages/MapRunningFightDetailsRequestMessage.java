

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MapRunningFightDetailsRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5750;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    
    public MapRunningFightDetailsRequestMessage() { }
    
    public MapRunningFightDetailsRequestMessage(int fightId) {
        this.fightId = fightId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
    }
    
}
