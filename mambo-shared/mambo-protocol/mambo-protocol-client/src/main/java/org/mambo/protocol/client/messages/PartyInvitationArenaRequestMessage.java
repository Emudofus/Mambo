

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationArenaRequestMessage extends PartyInvitationRequestMessage {
    public static final int MESSAGE_ID = 6283;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public PartyInvitationArenaRequestMessage() { }
    
    public PartyInvitationArenaRequestMessage(String name) {
        super(name);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
