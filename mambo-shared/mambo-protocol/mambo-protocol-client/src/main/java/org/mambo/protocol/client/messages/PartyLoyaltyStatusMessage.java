

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
