

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyRestrictedMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6175;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean restricted;
    
    public PartyRestrictedMessage() { }
    
    public PartyRestrictedMessage(int partyId, boolean restricted) {
        super(partyId);
        this.restricted = restricted;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(restricted);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        restricted = reader.readBoolean();
    }
    
}
