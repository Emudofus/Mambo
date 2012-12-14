

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyFollowThisMemberRequestMessage extends PartyFollowMemberRequestMessage {
    public static final int MESSAGE_ID = 5588;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    
    public PartyFollowThisMemberRequestMessage() { }
    
    public PartyFollowThisMemberRequestMessage(int partyId, int playerId, boolean enabled) {
        super(partyId, playerId);
        this.enabled = enabled;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(enabled);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        enabled = reader.readBoolean();
    }
    
}
