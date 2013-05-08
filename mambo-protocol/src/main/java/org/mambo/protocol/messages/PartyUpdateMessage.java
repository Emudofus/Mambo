

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyUpdateMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5575;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PartyMemberInformations memberInformations;
    
    public PartyUpdateMessage() { }
    
    public PartyUpdateMessage(int partyId, PartyMemberInformations memberInformations) {
        super(partyId);
        this.memberInformations = memberInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(memberInformations.getTypeId());
        memberInformations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        memberInformations = ProtocolTypeManager.getInstance().build(buf.readShort());
        memberInformations.deserialize(buf);
    }
    
}
