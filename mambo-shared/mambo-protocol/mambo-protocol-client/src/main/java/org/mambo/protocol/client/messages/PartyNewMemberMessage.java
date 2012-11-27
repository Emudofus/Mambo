

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class PartyNewMemberMessage extends PartyUpdateMessage {
    public static final int MESSAGE_ID = 6306;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyNewMemberMessage() { }
    
    public PartyNewMemberMessage(int partyId, PartyMemberInformations memberInformations) {
        super(partyId, memberInformations);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
