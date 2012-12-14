

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractPartyMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6274;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int partyId;
    
    public AbstractPartyMessage() { }
    
    public AbstractPartyMessage(int partyId) {
        this.partyId = partyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(partyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        partyId = reader.readInt();
        if (partyId < 0)
            throw new RuntimeException("Forbidden value on partyId = " + partyId + ", it doesn't respect the following condition : partyId < 0");
    }
    
}
