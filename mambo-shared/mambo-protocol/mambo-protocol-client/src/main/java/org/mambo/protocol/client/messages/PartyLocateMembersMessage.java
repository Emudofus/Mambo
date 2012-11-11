

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(geopositions.length);
        for (PartyMemberGeoPosition entry : geopositions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        geopositions = new PartyMemberGeoPosition[limit];
        for (int i = 0; i < limit; i++) {
            geopositions[i] = new PartyMemberGeoPosition();
            geopositions[i].deserialize(reader);
        }
    }
    
}
