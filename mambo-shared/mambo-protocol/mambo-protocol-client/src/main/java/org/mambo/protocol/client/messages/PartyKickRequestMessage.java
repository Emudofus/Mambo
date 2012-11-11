

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyKickRequestMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5592;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    
    public PartyKickRequestMessage() { }
    
    public PartyKickRequestMessage(int partyId, int playerId) {
        super(partyId);
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(playerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
