

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyKickedByMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5590;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kickerId;
    
    public PartyKickedByMessage() { }
    
    public PartyKickedByMessage(int partyId, int kickerId) {
        super(partyId);
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
