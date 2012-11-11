

// Generated on 11/11/2012 19:17:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyMemberEjectedMessage extends PartyMemberRemoveMessage {
    public static final int MESSAGE_ID = 6252;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kickerId;
    
    public PartyMemberEjectedMessage() { }
    
    public PartyMemberEjectedMessage(int partyId, int leavingPlayerId, int kickerId) {
        super(partyId, leavingPlayerId);
        this.kickerId = kickerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(kickerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        kickerId = reader.readInt();
        if (kickerId < 0)
            throw new RuntimeException("Forbidden value on kickerId = " + kickerId + ", it doesn't respect the following condition : kickerId < 0");
    }
    
}
