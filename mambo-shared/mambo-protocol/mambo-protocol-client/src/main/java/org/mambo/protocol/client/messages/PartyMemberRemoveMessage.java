

// Generated on 12/14/2012 18:44:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyMemberRemoveMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 5579;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int leavingPlayerId;
    
    public PartyMemberRemoveMessage() { }
    
    public PartyMemberRemoveMessage(int partyId, int leavingPlayerId) {
        super(partyId);
        this.leavingPlayerId = leavingPlayerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(leavingPlayerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        leavingPlayerId = reader.readInt();
        if (leavingPlayerId < 0)
            throw new RuntimeException("Forbidden value on leavingPlayerId = " + leavingPlayerId + ", it doesn't respect the following condition : leavingPlayerId < 0");
    }
    
}
