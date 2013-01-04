

// Generated on 01/04/2013 14:54:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyLeaderUpdateMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5578;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int partyLeaderId;
    
    public PartyLeaderUpdateMessage() { }
    
    public PartyLeaderUpdateMessage(int partyId, int partyLeaderId) {
        super(partyId);
        this.partyLeaderId = partyLeaderId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(partyLeaderId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        partyLeaderId = reader.readInt();
        if (partyLeaderId < 0)
            throw new RuntimeException("Forbidden value on partyLeaderId = " + partyLeaderId + ", it doesn't respect the following condition : partyLeaderId < 0");
    }
    
}
