

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyLocateMembersMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5595;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PartyMemberGeoPosition[] geopositions;
    
    public PartyLocateMembersMessage() { }
    
    public PartyLocateMembersMessage(int partyId, PartyMemberGeoPosition[] geopositions) {
        super(partyId);
        this.geopositions = geopositions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(geopositions.length);
        for (PartyMemberGeoPosition entry : geopositions) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        geopositions = new PartyMemberGeoPosition[limit];
        for (int i = 0; i < limit; i++) {
            geopositions[i] = new PartyMemberGeoPosition();
            geopositions[i].deserialize(buf);
        }
    }
    
}
