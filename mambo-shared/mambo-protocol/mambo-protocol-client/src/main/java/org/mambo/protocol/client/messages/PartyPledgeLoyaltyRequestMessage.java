

// Generated on 12/14/2012 18:44:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6269;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean loyal;
    
    public PartyPledgeLoyaltyRequestMessage() { }
    
    public PartyPledgeLoyaltyRequestMessage(int partyId, boolean loyal) {
        super(partyId);
        this.loyal = loyal;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(loyal);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        loyal = reader.readBoolean();
    }
    
}
