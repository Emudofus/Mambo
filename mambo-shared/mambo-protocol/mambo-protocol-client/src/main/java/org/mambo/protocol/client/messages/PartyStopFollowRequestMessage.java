

// Generated on 01/04/2013 14:54:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyStopFollowRequestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5574;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyStopFollowRequestMessage() { }
    
    public PartyStopFollowRequestMessage(int partyId) {
        super(partyId);
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
