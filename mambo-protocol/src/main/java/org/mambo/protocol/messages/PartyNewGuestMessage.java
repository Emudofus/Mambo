

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        guest.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guest = new PartyGuestInformations();
        guest.deserialize(buf);
    }
    
}
