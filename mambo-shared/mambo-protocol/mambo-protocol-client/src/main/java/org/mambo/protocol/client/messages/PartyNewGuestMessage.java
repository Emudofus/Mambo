

// Generated on 01/04/2013 14:54:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyNewGuestMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 6260;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PartyGuestInformations guest;
    
    public PartyNewGuestMessage() { }
    
    public PartyNewGuestMessage(int partyId, PartyGuestInformations guest) {
        super(partyId);
        this.guest = guest;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        guest.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guest = new PartyGuestInformations();
        guest.deserialize(reader);
    }
    
}
