

// Generated on 01/04/2013 14:54:29
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyCannotJoinErrorMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5583;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public PartyCannotJoinErrorMessage() { }
    
    public PartyCannotJoinErrorMessage(int partyId, byte reason) {
        super(partyId);
        this.reason = reason;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        reason = reader.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
    }
    
}
