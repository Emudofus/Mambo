

// Generated on 01/04/2013 14:54:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyLoyaltyStatusMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6270;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean loyal;
    
    public PartyLoyaltyStatusMessage() { }
    
    public PartyLoyaltyStatusMessage(int partyId, boolean loyal) {
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
