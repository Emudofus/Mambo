

// Generated on 11/11/2012 19:17:05
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5585;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public PartyInvitationRequestMessage() { }
    
    public PartyInvitationRequestMessage(String name) {
        this.name = name;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
    }
    
}
